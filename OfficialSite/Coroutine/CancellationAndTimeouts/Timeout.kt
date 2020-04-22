import kotlinx.coroutines.*

/*
 * コルーチン：タイムアウト
 */
fun main() = runBlocking {

    println("---Timeout---")

    // 1300ミリ秒後にタイムアウト例外(TimeoutCancellationException)を出す
    try{
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }    
    }catch(ex: TimeoutCancellationException){
        println("TimeoutCancellationException!!")
    }
    println("　")

    println("> withTimeoutOrNull")
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }

        // タイムアウトせずにすべて終わればDoneが返る
        "Done"
    }
    // 途中でタイムアウトするため、ジョブの結果はnullになる
    println("Result is $result")

}

// 出力：
// ---Timeout---
// I'm sleeping 0 ...
// I'm sleeping 1 ...
// I'm sleeping 2 ...
// TimeoutCancellationException!!
// 　
// > withTimeoutOrNull
// I'm sleeping 0 ...
// I'm sleeping 1 ...
// I'm sleeping 2 ...
// Result is null