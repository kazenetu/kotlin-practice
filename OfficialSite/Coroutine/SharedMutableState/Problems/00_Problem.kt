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

var counter = 0

/*
 * コルーチン：共有された変更可能な状態と並行性：問題点1
 * 変更可能な共有状態へのアクセスの同期が問題となる
 */
fun main() = runBlocking<Unit> {

    // 改善前の問題点
    // それぞれのコルーチンがcounterを同期せずに複数のスレッドから同時にインクリメントする。
    // そのため「Counter = 100000」を出力することはほぼない。
    println("---The problem---")

    withContext(Dispatchers.Default) {
        massiveRun {
            // 単一のリソースをインクリメントして更新
            counter++
        }
    }

    // 最終の値を出力
    println("Counter = $counter")

}

// 出力：
// ---The problem---
// Completed 100000 actions in 14 ms
// Counter = 70790