import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
           
fun foo(): Flow<Int> = flow {
    log("Started foo flow")
    for (i in 1..3) {
        emit(i)
    }
}  

/*
 * コルーチン：非同期フロー：フローコンテキスト
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * 呼び出し元のコルーチンのコンテキストで常に行われる
 * デフォルトでは、flow { ... }ビルダーのコードは、
 * 対応するフローのコレクターによって提供されるコンテキストで実行される
 */
fun main() = runBlocking<Unit> {

    // フローコンテキスト
    println("---Flow context---")

    // foo().collectはメインスレッドから呼び出されるため、
    // fooフローの本体もメインスレッドで呼び出される。
    // これは、実行コンテキストを気にせず、呼び出し元をブロックしない、
    // 高速実行または非同期コードの完全なデフォルトである。
    foo().collect { value -> log("Collected $value") }
}

// 出力：
// ---Flow context---
// [main @coroutine#1] Started foo flow
// [main @coroutine#1] Collected 1
// [main @coroutine#1] Collected 2
// [main @coroutine#1] Collected 3