import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {

        // なにかしらの処理
        Thread.sleep(100)

        // flow中のスレッドを表示
        log("Emitting $i")

        // 次の値を生成
        emit(i)
    }
}.flowOn(Dispatchers.Default) // フロービルダーでコンテキスト変更

/*
 * コルーチン：非同期フロー：flowOnオペレーター
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * flowOnでフローのコンテキストを変更する正しい方法
 */
fun main() = runBlocking<Unit> {

    // flowOnオペレーター
    println("---flowOn operator---")

    // 対応するスレッドの名前も出力して、すべてがどのように機能するかを示す
    foo().collect { value ->
        log("Collected $value") 
    } 
}  

// 出力：
// ---flowOn operator---
// [DefaultDispatcher-worker-1 @coroutine#2] Emitting 1
// [main @coroutine#1] Collected 1
// [DefaultDispatcher-worker-1 @coroutine#2] Emitting 2
// [main @coroutine#1] Collected 2
// [DefaultDispatcher-worker-1 @coroutine#2] Emitting 3
// [main @coroutine#1] Collected 3