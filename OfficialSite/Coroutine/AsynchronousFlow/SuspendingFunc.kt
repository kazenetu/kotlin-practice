import kotlinx.coroutines.*

suspend fun foo(): List<Int> {
    // 何かの処理を行ったとして100ミリ秒待つ
    delay(100)
    
    // リストを返す
    return listOf(1, 2, 3)
}

/*
 * コルーチン：非同期フロー：一時停止メソッド
 * 一気に計算結果を返す
 * おさらい
 * See:../Basic/FunctionRefactoring_HellowWorld.kt
 */
fun main() = runBlocking {
    
    // メインスレッドをブロックしない
    println("---Suspending functions---")

    foo().forEach { value -> println(value) } 
    println("main end!")
}

// 出力：
// ---Suspending functions---
// 1
// 2
// 3
// main end!