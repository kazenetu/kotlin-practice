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
 * 一時停止メソッド1と2の非同期実行とその結果を返す
 */
suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}

/*
 * コルーチン：一時停止：非同期(メソッドの構造化)
 */
fun main() = runBlocking {

    // メソッド1・メソッド2の非同期処理
    println("--Structured concurrency with async---")
    val time = measureTimeMillis {
        // メソッド1と2を非同期実行するメソッドを呼び出し
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")    

}

// 出力：
// --Structured concurrency with async---
// The answer is 42
// Completed in 1016 ms