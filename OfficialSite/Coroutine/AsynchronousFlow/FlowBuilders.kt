import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * コルーチン：非同期フロー：Flowビルダー実装の別パターン
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * Flowの実行方法のパターン
 */
fun main() = runBlocking<Unit> {

    // Flowビルダー実装の別パターン
    println("---Flow builders---")

    println("> (1..3).asFlow().collect { value -> println(value) } ")
    (1..3).asFlow().collect { value -> println(value) } 
    println("　")

    println("> flowOf(1, 3, 5).collect{ value -> println(value) }")
    flowOf(1, 3, 5).collect{a -> println(a)}

}

// 出力：
// ---Flow builders---
// > (1..3).asFlow().collect { value -> println(value) }
// 1
// 2
// 3
// 　
// > flowOf(1, 3, 5).collect{ value -> println(value) }
// 1
// 3
// 5