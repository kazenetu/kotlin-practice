import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun numbers(): Flow<Int> = flow {
    try {                          
        emit(1)
        emit(2) 
        println("This line will not execute")
        emit(3)    
    } finally {
        println("Finally in numbers")
    }
}

/*
 * コルーチン：非同期フロー：サイズ制限中間演算子
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * takeのようなサイズ制限中間演算子は、対応する制限に達したときにフローの実行をキャンセルする。
 * ルーチンでのキャンセルは常に例外をスローすることによって実行される。
 * よって、try { ... } finally { ... }ブロックなどを併用する。
 */
fun main() = runBlocking<Unit> {

    // サイズ制限中間演算子
    println("---Size-limiting operators---")

    // emit(1),emit(2)まで実行・表示
    numbers() 
        .take(2)
        .collect { value -> println(value) }
}

// 出力：
// ---Size-limiting operators---
// 1
// 2
// Finally in numbers