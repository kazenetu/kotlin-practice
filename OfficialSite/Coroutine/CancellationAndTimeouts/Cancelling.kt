import kotlinx.coroutines.*

/*
 * コルーチン：キャンセル
 */
fun main() = runBlocking {

    println("---Cancelling---")

    // コルーチンのキャンセル
    println("> Cancelling coroutine execution")
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    // 少し待つ
    delay(1300L)
    println("main: I'm tired of waiting!")
    // ジョブをキャンセルし待つ(cancelAndJoin()でもよい)
    job.cancel()
    job.join()
    println("main: Now I can quit.")
    println("　")

    // 具体的なコルーチンのキャンセル
    println("> Cancelling coroutine execution")
    val startTime = System.currentTimeMillis()
    val job2 = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // キャンセルしていない条件でループする
            // 500ミリ秒ごとにメッセージを表示
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    // 少し待つ
    delay(1300L)
    println("main: I'm tired of waiting!")
    // ジョブをキャンセルし待つ
    job2.cancelAndJoin()
    println("main: Now I can quit.")
    println("　")

    // リソースのクローズ処理
    println("> Closing resources with finally")
    val job3 = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            // リソースのクローズ処理(必ず実行)
            println("job: I'm running finally")
        }
    }
    // 少し待つ
    delay(1300L)
    println("main: I'm tired of waiting!")
    // ジョブをキャンセルし待つ
    job3.cancelAndJoin()
    println("main: Now I can quit.")
    println("　")

    // リソースのクローズ処理(キャンセル不可スコープ)
    println("> Run non-cancellable block")
    val job4 = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            // キャンセル不可スコープ内はキャンセルできない
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    // 少し待つ
    delay(1300L)
    println("main: I'm tired of waiting!")
    // ジョブをキャンセルし待つ
    job4.cancelAndJoin()
    println("main: Now I can quit.")

}

// 出力：
// ---Cancelling---
// > Cancelling coroutine execution
// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// main: Now I can quit.
// 　
// > Cancelling coroutine execution
// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// main: Now I can quit.
// 　
// > Closing resources with finally
// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// job: I'm running finally
// main: Now I can quit.
// 　
// > Run non-cancellable block
// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// job: I'm running finally
// job: And I've just delayed for 1 sec because I'm non-cancellable
// main: Now I can quit.