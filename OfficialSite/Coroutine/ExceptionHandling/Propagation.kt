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
// ---Exception Handling---
// Throwing exception from launch
// Exception in thread "DefaultDispatcher-worker-1" java.lang.IndexOutOfBoundsException
//         at SampleKt$main$1$job$1.invokeSuspend(Sample.kt:16)
//         at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
//         at kotlinx.coroutines.DispatchedTask.run(Dispatched.kt:238)
//         at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:594)
//         at kotlinx.coroutines.scheduling.CoroutineScheduler.access$runSafely(CoroutineScheduler.kt:60)
//         at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:742)
// Joined failed job
// Throwing exception from async
// Caught ArithmeticException