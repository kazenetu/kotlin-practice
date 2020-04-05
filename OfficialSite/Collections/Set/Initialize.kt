/*
 * コレクション：Set(重複を許さないList)
 */
fun main() {

    // 初期化
    println("---Set : Initialize---")
    println("setOf(1, 2, 3, 4) = ${setOf(1, 2, 3, 4)}")
    println("(1..10).toSet() = ${ (1..10).toSet() }")
    println("emptySet<String>() = ${ emptySet<String>() }")

}

// 出力：
// ---Set : Initialize---
// setOf(1, 2, 3, 4) = [1, 2, 3, 4]
// (1..10).toSet() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// emptySet<String>() = []
