/*
 * 変換：平坦化用データクラス
 */
data class StringContainer(val values: List<String>)

/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")
    println("> Transformations : Flattening") // 変換：平坦化
    println("listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)).flatten() = ${ listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)).flatten() }")
    val stringContainers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println("stringContainers = $stringContainers")
    println("stringContainers.flatMap { it.values } = ${stringContainers.flatMap { it.values }}") // データクラスでの平坦化
    println("　")

    println("> Transformations : String representation") // 変換：コレクションの文字列化
    println("listOf(\"one\", \"two\", \"three\").joinToString() = ${ listOf("one", "two", "three").joinToString() }")
    println("listOf(\"one\", \"two\", \"three\").joinToString(separator = \" | \", prefix = \"start: \", postfix = \": end\") = ${ listOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\") = ${ listOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>") }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\", separator = \" \") = ${ listOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>", separator = " ") }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString { \"<\${it.toUpperCase()}>\" } = ${ listOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString(transform = { \"<\${it.toUpperCase()}>\" }) = ${ listOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) }")
    println("　")

    val stringBuffer = StringBuffer("The list of numbers: ") // バッファにコピー
    listOf("one", "two", "three").joinTo(stringBuffer)
    println("listOf(\"one\", \"two\", \"three\").joinTo(stringBuffer) = $stringBuffer")

}

// 出力：
// ---common Operators---
// > Transformations : Flattening
// listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)).flatten() = [1, 2, 3, 4, 10, 20, 30, 40]
// stringContainers = [StringContainer(values=[one, two, three]), StringContainer(values=[four, five, six]), StringContainer(values=[seven, eight])]
// stringContainers.flatMap { it.values } = [one, two, three, four, five, six, seven, eight]
// 　
// > Transformations : String representation
// listOf("one", "two", "three").joinToString() = one, two, three
// listOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") = start: one | two | three: end
// listOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>") = one, two, three, <next...>
// listOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>", separator = " ") = one two three <next...>
// listOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } = <ONE>, <TWO>, <THREE>, <FOUR>
// listOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) = <ONE>, <TWO>, <THREE>, <FOUR>
// 　
// listOf("one", "two", "three").joinTo(stringBuffer) = The list of numbers: one, two, three
