import kotlinx.coroutines.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

/*
 * コルーチン：ディスパッチャーとスレッド：デバッグ
 *
 * ※実行時に「-Dkotlinx.coroutines.debug」を指定する
 */
fun main() = runBlocking {

    // すべてrunBlocking内で実行される。実行順番に注意。
    println("---Debugging coroutines and threads---")
    val a = async {
        log("asyncA")
        6
    }
    val b = async {
        log("asyncB")
        7
    }
    log("The answer is ${a.await() * b.await()}")

}

// 出力：
// ---Debugging coroutines and threads---
// [main @coroutine#2] asyncA
// [main @coroutine#3] asyncB
// [main @coroutine#1] The answer is 42