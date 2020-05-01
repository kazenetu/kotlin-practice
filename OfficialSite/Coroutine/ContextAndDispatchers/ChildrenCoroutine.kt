import kotlinx.coroutines.*

/*
 * コルーチン：ディスパッチャーとスレッド：兄弟コルーチンのキャンセル
 */
fun main() = runBlocking {

    // 「GlobalScopeとrunBlockingに属するスレッドの兄弟コルーチン」のキャンセル時の動作の違い
    println("---Children of a coroutine---")

    val request = launch {
        GlobalScope.launch {
            // GlobalScopeのためキャンセル対象外
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }

        // 親(runBlocking)に属するスレッドのためキャンセル対象
        launch {
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    // 500ミリ秒まってジョブをキャンセル
    delay(500)
    request.cancel()
    println("main: run request.cancel()")

    // GlobalScopeコルーチンの実行待ち
    delay(1000)
    println("main: Who has survived request cancellation?")

}

// 出力：
// ---Children of a coroutine---
// job1: I run in GlobalScope and execute independently!
// job2: I am a child of the request coroutine
// main: run request.cancel()
// job1: I am not affected by cancellation of the request
// main: Who has survived request cancellation?