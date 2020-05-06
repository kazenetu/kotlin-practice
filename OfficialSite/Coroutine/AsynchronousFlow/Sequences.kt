import kotlinx.coroutines.*

fun foo(): Sequence<Int> = sequence { // シーケンスビルダー
    // 毎回計算に100ミリ秒かかる
    for (i in 1..3) {
        // 何かの処理を行ったとして100ミリ秒待つ
        Thread.sleep(100)

        // 次の値を生成
        yield(i)
    }
}

/*
 * コルーチン：非同期フロー：シーケンス
 */
fun main() {
    // メインスレッドで実行するためブロックが発生する
    println("---Sequences---")
    foo().forEach { value -> println(value) } 
    println("main end!")
}

// 出力：
// ---Sequences---
// 1
// 2
// 3
// main end!