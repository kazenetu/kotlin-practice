import kotlinx.coroutines.*
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

val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

/*
 * コルーチン：共有された変更可能な状態と並行性：細かいスレッドの制限
 * 変更可能な共有状態へのアクセスの同期が問題となる
 */
fun main() = runBlocking<Unit> {

    // 解決策2
    // リソースにインクリメントするときはシングルスレッド化する。
    // ※弊害として時間がかかる。
    println("---Thread confinement fine-grained---")

    withContext(Dispatchers.Default) {
        massiveRun {
            // シングルスレッド化：一度に1スレッドのみインクリメント
            withContext(counterContext) {
                counter++
            }
        }
    }

    // 最終の値を出力
    println("Counter = $counter")

}

// 出力：
