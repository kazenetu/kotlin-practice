/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")
    println("> plus and minus Operators")   //リストの追加と削除を生成
    println("emptyList<String>() + \"ABC\" = ${ emptyList<String>() + "ABC" }")
    println("listOf(1, 2, 3, 4) - 1 = ${listOf(1, 2, 3, 4) - 1}")

}

// 出力：
// ---common Operators---
// > plus and minus Operators
// emptyList<String>() + "ABC" = [ABC]
// listOf(1, 2, 3, 4) - 1 = [2, 3, 4]
