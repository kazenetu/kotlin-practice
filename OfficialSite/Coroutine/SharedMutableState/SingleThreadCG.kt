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
 * コルーチン：共有された変更可能な状態と並行性：荒いスレッド制限
 * 変更可能な共有状態へのアクセスの同期が問題となる
 */
fun main() = runBlocking<Unit> {

    // 解決策3
    // 実際には、スレッドの制限は大きなチャンクで実行される。
    // たとえば、状態を更新するビジネスロジックの大きな部分は単一のスレッドに制限される。
    // 次の例はそのようにして、最初にシングルスレッドコンテキストで各コルーチンを実行している。
    // 解決策2：SingleThread.ktより速い
    println("---Thread confinement coarse-grained---")

    // シングルスレッドで実行
    withContext(counterContext) {
        massiveRun {
            counter++
        }
    }

    // 最終の値を出力
    println("Counter = $counter")

}

// 出力：
// ---Thread confinement coarse-grained---
// Completed 100000 actions in 23 ms
// Counter = 100000