/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 初期化
    println("---ReadOnly List : Initialize---")
    println("listOf(1, 2, 3, 4) = ${listOf(1, 2, 3, 4)}")
    println("List(10, {it}) = ${ List(10, {it}) }")
    println("List(10){it} = ${ List(10){it} }")
    println("(1..10).toList() = ${ (1..10).toList() }")
    println("emptyList<String>() = ${ emptyList<String>() }")
    println("listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)) = ${ listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)) }")

}

// 出力：
// ---ReadOnly List : Initialize---
// listOf(1, 2, 3, 4) = [1, 2, 3, 4]
// List(10, {it}) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// List(10){it} = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// (1..10).toList() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// emptyList<String>() = []
// listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)) = [[1, 2, 3, 4], [10, 20, 30, 40]]
