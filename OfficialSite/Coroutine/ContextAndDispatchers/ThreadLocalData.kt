import kotlinx.coroutines.*

// スレッドローカルの宣言
val threadLocal = ThreadLocal<String?>()

/*
 * コルーチン：ディスパッチャーとスレッド：スレッドローカル
 */
fun main() = runBlocking<Unit> {

    // スレッド間の値のやりとり
    println("---Coroutine scope---")

    // スレッドローカルに値を設定
    threadLocal.set("main")
    println("> Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    println("　")

    // ジョブの設定・実行(コンテキストの合成でスレッドローカルの値変更)
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
        println("　")
        println("> Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        yield()
        println("> After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    }

    // 実行待ち
    println("> job.join()")
    job.join()

    println("　")
    println("> Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")    
}

// 出力：
// ---Coroutine scope---
// > Pre-main, current thread: Thread[main @coroutine#1,5,main], thread local value: 'main'
// 　
// > job.join()
// 　
// > Launch start, current thread: Thread[DefaultDispatcher-worker-2 @coroutine#2,5,main], thread local value: 'launch'
// > After yield, current thread: Thread[DefaultDispatcher-worker-3 @coroutine#2,5,main], thread local value: 'launch'
// 　
// > Post-main, current thread: Thread[main @coroutine#1,5,main], thread local value: 'main'