import kotlinx.coroutines.*

/*
 * コルーチン：基本：スコープ定義
 * すべてが並列で実行される
 */
fun main() = runBlocking {

    println("---Scope builder---")

    // runBlockingからのタスク
    launch { 
        delay(200L)
        println("2.[WAIT 200ms] Task from runBlocking")
    }
    
    // coroutineスコープ作成
    coroutineScope {
        // さらにコルーチン作成
        launch {
            delay(500L) 
            println("3.[WAIT 500ms] Task from nested launch")
        }
    
        // さきに作成したタスクの前に実行
        delay(100L)
        println("1.[WAIT 100ms] Task from coroutine scope")
    }
    
    // coroutineScopeが完了したあとに実行
    println("4.Coroutine scope is over")
}

// 出力：
// ---Scope builder---
// 1.[WAIT 100ms] Task from coroutine scope
// 2.[WAIT 200ms] Task from runBlocking
// 3.[WAIT 500ms] Task from nested launch
// 4.Coroutine scope is over