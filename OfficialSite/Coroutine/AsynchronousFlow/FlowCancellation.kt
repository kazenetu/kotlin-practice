import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow { 
    for (i in 1..3) {
        delay(100)          
        println("Emitting $i")
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：Flowのキャンセル
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * Flowのキャンセルはdelayなど一時停止系メソッドでキャンセルできる
 * これらがないものはキャンセルできない
 */
fun main() = runBlocking<Unit> {

    // Flowのキャンセル
    println("---Flow cancellation---")

    // 250ミリ秒でタイムアウト
    withTimeoutOrNull(250) {
        foo().collect { value -> println(value) } 
    }
    println("Done")
}

// 出力：
// ---Flow cancellation---
// Emitting 1
// 1
// Emitting 2
// 2
// Done