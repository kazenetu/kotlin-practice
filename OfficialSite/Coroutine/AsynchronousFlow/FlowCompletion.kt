import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow { 
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

fun fooException(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}


/*
 * コルーチン：非同期フロー：通常/例外の最終処理
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 */
fun main() = runBlocking<Unit> {

    // 通常/例外の最終処理方法
    println("---Flow completion---")

    // try-catch-finally
    println("> try-catch-finally")
    try {
        foo().collect { value -> println(value) }
    } finally {
        println("Done")
    }
    println("　")

    // onCompletionで宣言
    println("> Declarative handling")
    foo()
        .onCompletion { println("Done") }
        .collect { value -> println(value) }
    println("　")

    // onCompletionで宣言；例外処理
    println("> Declarative handling:exception")
    fooException()
        .onCompletion { cause -> if (cause != null) println("Flow completed exceptionally") }
        .catch { cause -> println("Caught exception") }
        .collect { value -> println(value) }
    println("　")

    // 正常終了：正常終了
    println("> Successful completion")
    foo()
        .onCompletion { cause -> if (cause != null) println("Flow completed with $cause") }
        .collect { value ->
            println(value) 
        }
    println("　")

    // 正常終了：例外発生時
    println("> Successful completion:exception")
    foo()
        .onCompletion { cause -> if (cause != null) println("Flow completed with $cause") }
        .collect { value ->
            check(value <= 1) { "Collected $value" }                 
            println(value) 
        }
}

// 出力：
// ---Flow completion---
// > try-catch-finally
// Emitting 1
// 1
// Emitting 2
// 2
// Emitting 3
// 3
// Done
// 　
// > Declarative handling
// Emitting 1
// 1
// Emitting 2
// 2
// Emitting 3
// 3
// Done
// 　
// > Declarative handling:exception
// 1
// Flow completed exceptionally
// Caught exception
// 　
// > Successful completion
// Emitting 1
// 1
// Emitting 2
// 2
// Emitting 3
// 3
// 　
// > Successful completion:exception
// Emitting 1
// 1
// Emitting 2
// Flow completed with java.lang.IllegalStateException: Collected 2
// Exception in thread "main" java.lang.IllegalStateException: Collected 2