import kotlinx.coroutines.*

/*
 * コルーチン：基本
 */
fun main() {
    // バックグラウンドでコルーチンを実行
    GlobalScope.launch {
        // 一秒後にコンソール出力
        delay(1000L)
        println("World!")
    }
    // メインスレッドでのコンソール出力
    println("Hello,")

    // コルーチン実行完了まで2秒待機
    Thread.sleep(2000L)
}

// 出力：
// Hello,
// World!