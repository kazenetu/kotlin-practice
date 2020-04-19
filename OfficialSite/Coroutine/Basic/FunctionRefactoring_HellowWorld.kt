import kotlinx.coroutines.*

/*
 * コルーチン：基本：メソッドリファクタリング
 */
fun main() = runBlocking {

    println("---Extract function refactoring---")

    // バックグラウンドでコルーチンを実行
    launch { printWorld() }
    // メインスレッドでのコンソール出力
    println("Hello,")

}

/*
 * リファクタリングしたメソッド
 * suspendキーワード必須
 */
suspend fun printWorld()
{
    // 一秒後にコンソール出力
    delay(1000L)
    println("World!")
}

// 出力：
// ---Extract function refactoring---
// Hello,
// World!