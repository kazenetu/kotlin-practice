/*
 * コレクション：MutableList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")

    println("> isEmpty") // リストの空チェック
    println("emptyList<String>().toMutableList().isEmpty() = ${ emptyList<String>().toMutableList().isEmpty() }")
    println("mutableListOf(1, 2, 3, 4).isEmpty() = ${mutableListOf(1, 2, 3, 4).isEmpty()}")
    println("　")

    println("> isNotEmpty") // リストの要素ありチェック
    println("emptyList<String>().toMutableList().isNotEmpty() = ${ emptyList<String>().toMutableList().isNotEmpty() }")
    println("mutableListOf(1, 2, 3, 4).isNotEmpty() = ${mutableListOf(1, 2, 3, 4).isNotEmpty()}")

}

// 出力：
// ---common Operators---
// > isEmpty
// emptyList<String>().toMutableList().isEmpty() = true
// mutableListOf(1, 2, 3, 4).isEmpty() = false
// 　
// > isNotEmpty
// emptyList<String>().toMutableList().isNotEmpty() = false
// mutableListOf(1, 2, 3, 4).isNotEmpty() = true
