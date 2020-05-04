import kotlinx.coroutines.*

/*
 * コルーチン：ディスパッチャーとスレッド：コンテキストの合成
 */
fun main() = runBlocking<Unit> {

    // コンテキストの合成
    println("---Combining context elements---")

    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${ Thread.currentThread().name }")
    }
    
}

// 出力：
// ---Combining context elements---
// I'm working in thread DefaultDispatcher-worker-1 @test#2