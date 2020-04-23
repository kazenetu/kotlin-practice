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
 * コルーチン：一時停止：順次
 */
fun main() = runBlocking {

    // メソッド1→メソッド2の順番で順次処理
    println("---Sequential by default---")
    val time = measureTimeMillis {
        // デフォルトは順次に実行
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()

        // 結果を出力
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")    

}

// 出力：
// ---Sequential by default---
// The answer is 42
// Completed in 2007 ms