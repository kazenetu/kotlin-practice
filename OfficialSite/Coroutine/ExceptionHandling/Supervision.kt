import kotlinx.coroutines.*

/*
 * コルーチン：例外処理と監視：監視
 */
fun main() = runBlocking<Unit> {

    // 監視
    println("---Supervision ---")

    // SupervisorJobを使うことによって例外の監視が行える
    println(">> Supervision job")
    val supervisor = SupervisorJob()
    with(CoroutineScope(coroutineContext + supervisor)) {
        // 一番目の子コルーチン：例外を発生させる(実際に実装はNG)
        val firstChild = launch(CoroutineExceptionHandler { _, _ ->  }) {
            println("First child is failing")
            throw AssertionError("First child is cancelled")
        }
        // 二番目の子コルーチン：キャンセルとなる
        val secondChild = launch {
            // 一番目の子コルーチンを待つ
            firstChild.join()
            println("First child is cancelled: ${firstChild.isCancelled}, but second one is still active")
            try {
                // 長く待つ
                delay(Long.MAX_VALUE)
            } finally {
                // supervisor によってdelay処理はキャンセルされる
                println("Second child is cancelled because supervisor is cancelled")
            }
        }
        // 一番目の子コルーチンの実行完了(例外発生)を待つ
        firstChild.join()

        // SupervisorJobをキャンセルする
        println("Cancelling supervisor")
        supervisor.cancel()

        // 二番目のコルーチンの実行完了を待つ
        secondChild.join()
    }
    println("　")

    // supervisorScopeを使うことによって例外の範囲監視が行える
    println(">> Supervision scope")

    try {
        supervisorScope {
            val child = launch {
                try {
                    println("Child is sleeping")
                    delay(Long.MAX_VALUE)
                } finally {
                    println("Child is cancelled")
                }
            }
            // 子コルーチンの実行を実施
            yield()
            println("Throwing exception from scope")
            throw AssertionError()
        }
    } catch(e: AssertionError) {
        println("Caught assertion error")
    }

    println("　")

    // supervisorScope：監視ありコルーチンの例外
    // 通常のジョブとスーパーバイザージョブのもう1つの重要な違いは、例外処理である。
    // すべての子は、例外処理メカニズムを介して自分で例外を処理する必要がある。
    // この違いは、子供の失敗が親に伝播されないという事実に由来する。
    println(">> Exceptions in supervised coroutines")

    val handler = CoroutineExceptionHandler { _, exception -> 
        println("CoroutineExceptionHandler got $exception") 
    }
    supervisorScope {
        val child = launch(handler) {
            println("Child throws an exception")
            throw AssertionError()
        }
        println("Scope is completing")
    }
    println("Scope is completed")

}

// 出力：
// ---Supervision ---
// >> Supervision job
// First child is failing
// First child is cancelled: true, but second one is still active
// Cancelling supervisor
// Second child is cancelled because supervisor is cancelled
// 　
// >> Supervision scope
// Child is sleeping
// Throwing exception from scope
// Child is cancelled
// Caught assertion error