/*
 * コレクション：MutableList
 */
fun main() {

    // 初期化
    println("---Mutable List : Initialize---")
    println("mutableListOf(1, 2, 3, 4) = ${mutableListOf(1, 2, 3, 4)}")
    println("MutableList(10, {it}) = ${ MutableList(10, {it}) }")
    println("MutableList(10){it} = ${ MutableList(10){it} }")
    println("(1..10).toMutableList() = ${ (1..10).toMutableList() }")
    println("mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)) = ${ mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)) }")

}

// 出力：
// ---Mutable List : Initialize---
// mutableListOf(1, 2, 3, 4) = [1, 2, 3, 4]
// MutableList(10, {it}) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// MutableList(10){it} = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// (1..10).toMutableList() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)) = [[1, 2, 3, 4], [10, 20, 30, 40]]
