/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")

    println("> isEmpty") // リストの空チェック
    println("emptyList<String>().isEmpty() = ${ emptyList<String>().isEmpty() }")
    println("listOf(1, 2, 3, 4).isEmpty() = ${listOf(1, 2, 3, 4).isEmpty()}")
    println("　")

    println("> isNotEmpty") // リストの要素ありチェック
    println("emptyList<String>().isNotEmpty() = ${ emptyList<String>().isNotEmpty() }")
    println("listOf(1, 2, 3, 4).isNotEmpty() = ${listOf(1, 2, 3, 4).isNotEmpty()}")
}

// 出力：
// ---common Operators---
// > isEmpty
// emptyList<String>().isEmpty() = true
// listOf(1, 2, 3, 4).isEmpty() = false
// 　
// > isNotEmpty
// emptyList<String>().isNotEmpty() = false
// listOf(1, 2, 3, 4).isNotEmpty() = true
