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
 * コルーチン：非同期フロー：コンフレーション
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * フローが操作または操作ステータスの更新の部分的な結果を表す場合、
 * 各値を処理する必要はなく、最新の値のみを処理する必要がある。
 * コレクターが遅すぎて処理できない場合、conflateオペレーターを使用して中間値をスキップできる。
 */
fun main() = runBlocking<Unit> {

    // 最新が取得できればよい
    println("---Conflation---")

    val time = measureTimeMillis {
        foo()
             .conflate() // emitを収集しそれぞれを処理しない(最新であればよい)
             .collect { value -> 
                // 300ミリ秒待って値を表示
                delay(300)
                println(value) 
            } 
    }   
    println("Collected in $time ms")

}  

// 出力：
// ---Conflation---
// 1
// 3
// Collected in 805 ms