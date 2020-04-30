import kotlinx.coroutines.*

/*
 * コルーチン：ディスパッチャーとスレッド：ジョブ取得
 * coroutineContext[Job]を使用する
 */
fun main() = runBlocking {

    // コンテキストの一部であるジョブの状態を確認する
    println("---Job in the context---")
    println("My job is ${coroutineContext[Job]}")  
    println("　")

    // 非同期のジョブ
    val asyncJob = async { println("async job is ${coroutineContext[Job]}") }
    asyncJob.await()

}

// 出力：
// ---Job in the context---
// My job is "coroutine#1":BlockingCoroutine{Active}@5a2e4553
// 　
// async job is "coroutine#2":DeferredCoroutine{Active}@593634ad