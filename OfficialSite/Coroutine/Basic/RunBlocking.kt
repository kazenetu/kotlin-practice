import kotlinx.coroutines.*

/*
 * コルーチン：基本：メインコルーチン作成
 */
fun main() = runBlocking {

    println("---Waiting for a job---")

    // バックグラウンドで(GlobalScopeの)コルーチンを実行、jobローカルフィールドに格納
    val GlobalScopeJob = GlobalScope.launch {
        // 一秒後にコンソール出力
        delay(1000L)
        println("GlobalScopeJob:World!")
    }
    // メインスレッドでのコンソール出力
    println("GlobalScopeJob:Hello,")

    // ジョブが完了するまで待機
    GlobalScopeJob.join()

    println("　")
    println("---Structured concurrency---")

    // GlobalScopeはトップレベルでありメモリ不足の不安がある
    // また、アプリケーションの有効期間全体にわたって動作するため、乱用すると不都合などが生じる
    // CoroutineScopのコルーチンを実行する
    val CoroutineScopJob = launch {
        // 一秒後にコンソール出力
        delay(1000L)
        println("CoroutineScopJob:World!")
    }
    // メインスレッドでのコンソール出力
    println("CoroutineScopJob:Hello,")

    // ジョブが完了するまで待機
    CoroutineScopJob.join()

}

// 出力：
// ---Waiting for a job---
// GlobalScopeJob:Hello,
// GlobalScopeJob:World!
// 　
// ---Structured concurrency---
// CoroutineScopJob:Hello,
// CoroutineScopJob:World!