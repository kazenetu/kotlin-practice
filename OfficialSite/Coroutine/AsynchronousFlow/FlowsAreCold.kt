import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * suspendキーワードなし
 */     
fun foo(): Flow<Int> = flow { 
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：コールドストリーム
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 */
fun main() = runBlocking<Unit> {

    // コールドストリーム：受信しないかぎり動作しない
    println("---Flows are cold---")

    println("Calling foo...")
    val flow = foo()

    // 一回目
    println("Calling collect...")
    flow.collect { value -> println(value) } 

    // 二回目
    println("Calling collect again...")
    flow.collect { value -> println(value) } 
}

// 出力：
// ---Flows are cold---
// Calling foo...
// Calling collect...
// Flow started
// 1
// 2
// 3
// Calling collect again...
// Flow started
// 1
// 2
// 3