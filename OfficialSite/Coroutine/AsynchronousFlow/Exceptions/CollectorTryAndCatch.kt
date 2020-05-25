import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<String> = 
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i)
        }
    }
    .map { value ->
        // checkはfalseの場合は例外を出す(メッセージ)
        check(value <= 1) { "Crashed on $value" }

        "string $value"
    }

/*
 * コルーチン：非同期フロー：単純な例外処理2
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * collectはtry-catchで補足できる
 * エミッター、中間オペレーター、または端末オペレーターで発生する例外を実際にキャッチ可能
 */
fun main() = runBlocking<Unit> {

    // どこでも例外処理がキャッチ可能
    println("---Everything is caught---")

    try {
        foo().collect { value -> println(value) }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

// 出力：
// ---Everything is caught---
// Emitting 1
// string 1
// Emitting 2
// Caught java.lang.IllegalStateException: Crashed on 2