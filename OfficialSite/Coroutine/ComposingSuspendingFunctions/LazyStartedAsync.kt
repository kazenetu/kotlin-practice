import kotlinx.coroutines.*
import kotlin.system.*

/*
 * 一時停止メソッド1
 */
suspend fun doSomethingUsefulOne(): Int {
    // 何かの処理を行ったとして1000ミリ秒待つ
    delay(1000L)
    return 13
}

/*
 * 一時停止メソッド2
 */
suspend fun doSomethingUsefulTwo(): Int {
    // 何かの処理を行ったとして1000ミリ秒待つ
    delay(1000L)
    return 29
}

/*
 * コルーチン：一時停止：非同期（遅延実行）
 */
fun main() = runBlocking {

    // メソッド1・メソッド2の非同期処理
    println("---Concurrent using async---")
    val time = measureTimeMillis {
        // 非同期の遅延実行のジョブを作成
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }

        // startメソッドの呼び出しで処理実行
        one.start()
        two.start()

        // 処理が終わるまで待って結果を出力
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")    

}

// 出力：
// ---Concurrent using async---
// The answer is 42
// Completed in 1013 ms