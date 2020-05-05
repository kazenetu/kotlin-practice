import kotlin.coroutines.*
import kotlinx.coroutines.*

class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    // 破棄
    fun destroy() {
        // 自身(CoroutineScopeサブクラス)のキャンセル
        cancel()
    }


    // 処理メソッド   
    fun doSomething() {
        repeat(10) { i ->
            launch {
                // 実行の度に200ミリ秒待機する
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
    }
}

/*
 * コルーチン：ディスパッチャーとスレッド：コルーチンスコープ
 */
fun main() = runBlocking<Unit> {

    // コンテキストの合成
    println("---Coroutine scope---")

    // 対象クラスインスタンス生成
    val activity = Activity()

    // 処理メソッド実行
    activity.doSomething()
    println("Launched coroutines")

    // 500ミリ秒待機
    delay(500L)

    // 破棄(キャンセル)
    println("Destroying activity!")
    activity.destroy()

    // その後に実行されないことを確認
    delay(1000)
}

// 出力：
// ---Coroutine scope---
// Launched coroutines
// Coroutine 0 is done
// Coroutine 1 is done
// Destroying activity!