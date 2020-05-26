import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：単純な例外処理
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * collectはtry-catchで補足できる
 */
fun main() = runBlocking<Unit> {

    // 例外処理
    println("---Collector try and catch---")

    // collectターミナルオペレーターで例外を正常にキャッチする
    try {
        foo().collect { value ->         
            println(value)

            // checkはfalseの場合は例外を出す(メッセージ)
            check(value <= 1) { "Collected $value" }
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

// 出力：
// ---Collector try and catch---
// Emitting 1
// 1
// Emitting 2
// 2
// Caught java.lang.IllegalStateException: Collected 2