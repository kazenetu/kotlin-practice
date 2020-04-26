import kotlinx.coroutines.*

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> { 
        try {
            // 非常に重い処理
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> { 
        // 2つめのジョブで例外エラー発生
        println("Second child throws an exception")
        throw ArithmeticException()
    }

    // ジョブの非同期実行
    one.await() + two.await()
}

/*
 * コルーチン：一時停止：キャンセルの伝搬
 */
fun main() = runBlocking<Unit> {

    // 例外エラー
    println("--ancellation is always propagated through coroutines hierarchy---")
    try {
        // 例外エラーが発生するジョブ群を呼び出す
        failedConcurrentSum()
    } catch(e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

// 出力：
// --ancellation is always propagated through coroutines hierarchy---
// Second child throws an exception
// First child was cancelled
// Computation failed with ArithmeticException