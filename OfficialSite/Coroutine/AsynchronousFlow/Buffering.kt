import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {

        // 非同期で100ミリ秒待つ
        delay(100)

        // 次の値を返す
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：バッファリング
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * bufferオペレーターを使用すると
 * foo()内のdelay(100)は1回だけ実行、
 * それ以降は結果のみバッファリングとなる
 */
fun main() = runBlocking<Unit> {

    // バッファリング
    println("---Buffering---")

    // バッファリングしないパターン
    // (100ms+300ms) * 3count
    println("> not Buffering: (100ms+300ms)*3count")
    val time = measureTimeMillis {
        foo().collect { value -> 
            // 300ミリ秒待って値を表示
            delay(300)
            println(value) 
        } 
    }   
    println("Collected in $time ms")
    println("　")

    // バッファリングパターン ※foo()内のdelay(100)は1回だけ実行、それ以降は結果のみバッファリング
    // 100ms + 300ms *3count
    println("> not Buffering: 100ms + (300ms)*3count")
    val time2 = measureTimeMillis {
        foo()
            .buffer() // emitを収集し待たない
            .collect { value -> 
                // 300ミリ秒待って値を表示
                delay(300)
                println(value) 
            } 
    }   
    println("Collected in $time2 ms")

}  

// 出力：
// ---Buffering---
// > not Buffering: (100ms+300ms)*3count
// 1
// 2
// 3
// Collected in 1227 ms
// 　
// > not Buffering: 100ms + (300ms)*3count
// 1
// 2
// 3
// Collected in 1055 ms