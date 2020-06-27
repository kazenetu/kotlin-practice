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

}

// 出力：
// ---Supervision ---
// >> Supervision job
// First child is failing
// First child is cancelled: true, but second one is still active
// Cancelling supervisor
// Second child is cancelled because supervisor is cancelled