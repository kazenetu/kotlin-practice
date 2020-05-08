import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow { // フロービルダー
    // 毎回計算に100ミリ秒かかる
    for (i in 1..3) {
        // 何かの処理を行ったとして100ミリ秒待つ
        delay(100)

        // 次の値を生成
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：フロー
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 */
fun main() = runBlocking<Unit> {
    // メインスレッドをブロックしない
    println("---Suspending functions---")

    // 非同期スレッドで同時に実行されることを確認する
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }

    // Collectメソッドで処理を開始する
    foo().collect { value -> println(value) } 
    println("main end!")
}

// 出力：
// ---Suspending functions---
// I'm not blocked 1
// 1
// I'm not blocked 2
// 2
// I'm not blocked 3
// 3
// main end!