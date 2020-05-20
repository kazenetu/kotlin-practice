import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {

        // 非同期で100ミリ秒待つ
        delay(100)

        // 次の値を返す
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：最新の取得
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * conflateオペレーターでも処理が遅い場合はcollectLatestオペレータを使用する。
 * 遅いコレクターをキャンセルし、新しい値が発行されるたびにコレクターを再起動する。
 * 新しい値でブロック内のコードをキャンセルする。
 */
fun main() = runBlocking<Unit> {

    // 最新が取得できればよい：さらに重い処理用
    println("---Processing the latest value---")

    val time = measureTimeMillis {
        foo()
             .collectLatest { value -> 
                // collectLatestの本体には300ミリ秒かかる
                // 新しい値は100ミリ秒ごとに発行されるため、ブロックはすべての値で実行されるが
                // 最後の値に対してのみ完了する
                println("Collecting $value") 
                
                // 300ミリ秒待って値を表示
                delay(300)

                // 最終の値を取得
                println("Done $value")
            } 
    }   
    println("Collected in $time ms")

}  

// 出力：
// ---Processing the latest value---
// Collecting 1
// Collecting 2
// Collecting 3
// Done 3
// Collected in 709 ms