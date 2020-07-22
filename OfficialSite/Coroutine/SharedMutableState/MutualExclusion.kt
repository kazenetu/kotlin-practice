import kotlinx.coroutines.*
import kotlinx.coroutines.sync.*
import kotlin.system.*

suspend fun massiveRun(action: suspend () -> Unit) {
    // コルーチン数
    val n = 100

    // 1コルーチンでの繰り返し回数
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")  
}

val mutex = Mutex()
var counter = 0

/*
 * コルーチン：共有された変更可能な状態と並行性：相互排除
 * 変更可能な共有状態へのアクセスの同期が問題となる
 */
fun main() = runBlocking<Unit> {

    // 解決策4
    // 排他制御
    // kotlinx.coroutines.sync.* のインポートが必要
    // Mutex.lock()で排他制御する。
    // WithLockメソッドは「mutex.lock(); try { ... } finally { mutex.unlock() }」と同義。
    println("---Mutual exclusion---")

    // シングルスレッドで実行
    withContext(Dispatchers.Default) {
        massiveRun {
            // 排他ロック実行
            mutex.withLock {
                counter++
            }
        }
    }

    // 最終の値を出力
    println("Counter = $counter")

}

// 出力：
