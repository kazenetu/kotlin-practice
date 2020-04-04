/*
 * 変換：平坦化用データクラス
 */
data class StringContainer(val values: List<String>)

/*
 * コレクション：MutableList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")
    println("> Transformations : Flattening") // 変換：平坦化
    println("mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)).flatten() = ${ mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)).flatten() }")
    val stringContainers = mutableListOf(
        StringContainer(mutableListOf("one", "two", "three")),
        StringContainer(mutableListOf("four", "five", "six")),
        StringContainer(mutableListOf("seven", "eight"))
    )
    println("stringContainers = $stringContainers")
    println("stringContainers.flatMap { it.values } = ${stringContainers.flatMap { it.values }}") // データクラスでの平坦化
    println("　")

    println("> Transformations : String representation") // 変換：コレクションの文字列化
    println("mutableListOf(\"one\", \"two\", \"three\").joinToString() = ${ mutableListOf("one", "two", "three").joinToString() }")
    println("mutableListOf(\"one\", \"two\", \"three\").joinToString(separator = \" | \", prefix = \"start: \", postfix = \": end\") = ${ mutableListOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\") = ${ mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>") }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\", separator = \" \") = ${ mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>", separator = " ") }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString { \"<\${it.toUpperCase()}>\" } = ${ mutableListOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString(transform = { \"<\${it.toUpperCase()}>\" }) = ${ mutableListOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) }")
    println("　")

    val stringBuffer = StringBuffer("The list of numbers: ") // バッファにコピー
    mutableListOf("one", "two", "three").joinTo(stringBuffer)
    println("mutableListOf(\"one\", \"two\", \"three\").joinTo(stringBuffer) = $stringBuffer")

}

// 出力：
// ---common Operators---
// > Transformations : Flattening
// mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)).flatten() = [1, 2, 3, 4, 10, 20, 30, 40]
// stringContainers = [StringContainer(values=[one, two, three]), StringContainer(values=[four, five, six]), StringContainer(values=[seven, eight])]
// stringContainers.flatMap { it.values } = [one, two, three, four, five, six, seven, eight]
// 　
// > Transformations : String representation
// mutableListOf("one", "two", "three").joinToString() = one, two, three
// mutableListOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") = start: one | two | three: end
// mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>") = one, two, three, <next...>
// mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>", separator = " ") = one two three <next...>
// mutableListOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } = <ONE>, <TWO>, <THREE>, <FOUR>
// mutableListOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) = <ONE>, <TWO>, <THREE>, <FOUR>
// 　
// mutableListOf("one", "two", "three").joinTo(stringBuffer) = The list of numbers: one, two, three
