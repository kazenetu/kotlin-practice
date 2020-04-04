/*
 * コレクション：MutableList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")
    println("> plus and minus Operators")   //リストの追加と削除を生成
    println("(emptyList<String>() + \"ABC\").toMutableList() = ${ (emptyList<String>() + "ABC").toMutableList() }")
    println("mutableListOf(1, 2, 3, 4) - 1 = ${mutableListOf(1, 2, 3, 4) - 1}")

}

// 出力：
// ---common Operators---
// > plus and minus Operators
// (emptyList<String>() + "ABC").toMutableList() = [ABC]
// mutableListOf(1, 2, 3, 4) - 1 = [2, 3, 4]
