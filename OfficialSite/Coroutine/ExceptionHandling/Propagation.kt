import kotlinx.coroutines.*

/*
 * コルーチン：例外処理と監視：例外の伝播
 */
fun main() = runBlocking<Unit> {

    // 例外の伝播
    println("---Exception Handling---")

    // ルートのコルーチンを起動
    val job = GlobalScope.launch {
        println("Throwing exception from launch")

        // Thread.defaultUncaughtExceptionHandlerがコンソール出力される
        throw IndexOutOfBoundsException()
    }
    // ルートのコールーチンを待つが例外発生
    job.join()
    println("Joined failed job")

    // 非同期実行
    val deferred = GlobalScope.async {
        println("Throwing exception from async")

        // awaitが呼ばれるタイミングでコンソール出力される
        throw ArithmeticException()
    }
    try {
        deferred.await()

        // ここまで到達しない
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}

// 出力：
