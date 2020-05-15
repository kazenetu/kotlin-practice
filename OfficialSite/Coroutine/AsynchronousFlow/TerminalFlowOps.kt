import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * コルーチン：非同期フロー：終端演算子
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 */
fun main() = runBlocking<Unit> {

    // サイズ制限中間演算子
    println("---Terminal flow operators---")

    // 掛け算を合計
    println("> map - reduce")
    val sum = (1..5).asFlow()
        .map { it * it }
        .reduce { a, b -> a + b }
    println(sum)
    println("　")

    println("> toList()")
    val list = (1..5).asFlow()
            .toList()
    println(list)
    println("　")

}

// 出力：
// ---Terminal flow operators---
// > map - reduce
// 55
// 　
// > toList()
// [1, 2, 3, 4, 5]