import kotlinx.coroutines.*
import kotlin.system.*
import java.util.concurrent.atomic.*

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

var counter = AtomicInteger()

/*
 * コルーチン：共有された変更可能な状態と並行性：スレッドセーフなデータ構造
 * 変更可能な共有状態へのアクセスの同期が問題となる
 */
fun main() = runBlocking<Unit> {

    // 解決策1
    // スレッドセーフ（同期、線形化、またはアトミック）データ構造を使用する。
    // java.util.concurrent.atomicのインポートが必要。
    // ※プレーンカウンター、コレクション、キュー、その他の標準的なデータ構造、
    // 　およびそれらに対する基本的な操作で機能する。
    //
    // 　ただし、複雑な状態やすぐに使用できるスレッドセーフな実装がない複雑な操作に
    // 　簡単に拡張することはできない。
    println("---Thread-safe data structures---")

    withContext(Dispatchers.Default) {
        massiveRun {
            // 単一のリソースをインクリメントして更新
            counter.incrementAndGet()
        }
    }

    // 最終の値を出力
    println("Counter = $counter")

}

// 出力：
