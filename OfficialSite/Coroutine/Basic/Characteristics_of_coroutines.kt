import kotlinx.coroutines.*

/*
 * コルーチン：基本：特徴
 */
fun main() = runBlocking {

    // コルーチンの特徴
    println("---Characteristics of coroutines---")

    // 100個のコルーチンを作成して一斉に実行
    println("> Coroutines ARE light-weight")
    print("Create 100 coroutines:")
    repeat(100) {
        launch {
            delay(1000L)
            print(".")
        }
    }
    delay(1300L) 
    println("\n　")

    // GlobalScopeはアプリケーションの有効期間全体にわたって動作する
    println("> Global coroutines are like daemon threads")
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) 
}

// 出力：
// ---Characteristics of coroutines---
// > Coroutines ARE light-weight
// Create 100 coroutines:....................................................................................................
// 　
// > Global coroutines are like daemon threads
// I'm sleeping 0 ...
// I'm sleeping 1 ...
// I'm sleeping 2 ...