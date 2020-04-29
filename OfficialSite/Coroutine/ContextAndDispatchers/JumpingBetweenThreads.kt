import kotlinx.coroutines.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

/*
 * コルーチン：ディスパッチャーとスレッド：スレッドの切り替え
 *
 * ※実行時に「-Dkotlinx.coroutines.debug」を指定する
 */
fun main() {

    // 独自スレッドの作成とwithContextによる切り替え
    println("---Jumping between threads---")
    
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                // 独自スレッド1内
                log("Started in ctx1")

                // 独自スレッド2に切り替え
                withContext(ctx2) {
                    // 独自スレッド2内
                    log("Working in ctx2")
                }

                // 独自スレッド1内
                log("Back to ctx1")
            }
        }
    }    

}

// 出力：
// ---Jumping between threads---
// [Ctx1 @coroutine#1] Started in ctx1
// [Ctx2 @coroutine#1] Working in ctx2
// [Ctx1 @coroutine#1] Back to ctx1