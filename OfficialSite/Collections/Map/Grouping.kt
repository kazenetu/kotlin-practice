/*
 * コレクション：Map
 */
fun main() {

    // グルーピング
    println("---Map : Grouping---")
    println("> groupBy")
    // 要素を直接変換
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupBy { it.first().toUpperCase() } = ${ listOf("one", "two", "three", "four", "five").groupBy { it.first().toUpperCase() } }")
    // 要素の値を抽出したものを使用して変換
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }) = ${ listOf("one", "two", "three", "four", "five").groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }) }")
    println("　")

    println("> groupingBy") // グルーピングした各要素のカウントを行う※groupByではなくgroupingBy
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupingBy { it.first().toUpperCase() }.eachCount() = ${ listOf("one", "two", "three", "four", "five").groupingBy { it.first().toUpperCase() }.eachCount() }")

}

// 出力：
// ---Map : Grouping---
// > groupBy
// listOf("one", "two", "three", "four", "five").groupBy { it.first().toUpperCase() } = {O=[one], T=[two, three], F=[four, five]}
// listOf("one", "two", "three", "four", "five").groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }) = {o=[ONE], t=[TWO, THREE], f=[FOUR, FIVE]}
// 　
// > groupingBy
// listOf("one", "two", "three", "four", "five").groupingBy { it.first().toUpperCase() }.eachCount() = {O=1, T=2, F=2}