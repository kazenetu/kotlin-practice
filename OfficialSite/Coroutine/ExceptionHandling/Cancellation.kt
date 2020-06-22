import kotlinx.coroutines.*

/*
 * コルーチン：例外処理と監視：キャンセルと例外
 */
fun main() = runBlocking<Unit> {

    // キャンセルと例外
    println("---Cancellation and exceptions---")

    // キャンセル例
    println(">> Cancellation")
    val job = launch {
        // 子供のコルーチンを実行
        val child = launch {
            try {
                // 最大まで待機
                delay(Long.MAX_VALUE)
            } finally {
                println("Child is cancelled")
            }
        }
        yield()

        // 子供のコルーチンをキャンセル
        println("Cancelling child")
        child.cancel()
        child.join()
        yield()

        // 親のコルーチンはキャンセル・例外を伝播しない
        println("Parent is not cancelled")
    }
    job.join()

    println("　")

    // ネストしたコルーチンでの例外処理
    // 子供のコルーチンで例外が発生した場合はすべての子供が終了するまで処理されない
    println(">> Cancellation exceptions")
    val handler = CoroutineExceptionHandler { _, exception -> 
        println("CoroutineExceptionHandler got $exception") 
    }
    val job2 = GlobalScope.launch(handler) {

        // 子供のコルーチン1
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                // キャンセル不可ブロック処理の実行
                withContext(NonCancellable) {
                    println("Children are cancelled, but exception is not handled until all children terminate")
                    delay(100)
                    println("The first child finished its non cancellable block")
                }
            }
        }

        // 子供のコルーチン2
        launch {
            // 例外を発生させる
            delay(10)
            println("Second child throws an exception")
            throw ArithmeticException()
        }
    }
    job2.join()    
}

// 出力：
