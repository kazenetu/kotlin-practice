import kotlinx.coroutines.*
import java.io.*

/*
 * コルーチン：例外処理と監視：例外の集計
 *
 * コルーチンの複数の子が例外で失敗した場合、一般的なルールは「最初の例外が優先される」であるため、最初の例外が処理される。
 * 最初の例外の後に発生するすべての追加の例外は、抑制された例外として最初の例外に付加される。
 */
fun main() = runBlocking<Unit> {

    // 例外の集計
    println("---Exceptions aggregation and CancellationException ---")

    // 例外の集計
    println(">> Exceptions aggregation")
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception with suppressed ${exception.suppressed.contentToString()}")
    }

    val job = GlobalScope.launch(handler) {
        launch {
            try {
                // 兄弟コルーチンが例外を発生させるまで待機
                delay(Long.MAX_VALUE)
            } finally {
                // 2つ目の例外発生
                throw ArithmeticException()
            }
        }
        launch {
            delay(100)

            // 1つ目の例外発生
            throw IOException()
        }
        // 子コルーチンの実行を待つ
        delay(Long.MAX_VALUE)
    }
    job.join()
    println("　")

    println(">> CancellationException")
    val handler2 = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    val job2 = GlobalScope.launch(handler2) {
        val inner = launch {
            // このコルーチンはすべてキャンセルされる
            launch {
                launch {
                    // 例外発生させる
                    throw IOException()
                }
            }
        }
        try {
            inner.join()
        } catch (e: CancellationException) {
            println("Rethrowing CancellationException with original cause")

            // 再スローされるが、IOExceptionはハンドラに到達する
            throw e
        }
    }
    job2.join()
}

// 出力：
