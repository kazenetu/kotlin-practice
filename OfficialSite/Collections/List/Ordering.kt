/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 並び替え
    println("---ReadOnly List : Collection Ordering---")

    println("> Natural order")
    println("listOf(\"one\", \"two\", \"three\", \"four\").sorted()  = ${ listOf("one", "two", "three", "four").sorted() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\").sortedDescending()  = ${ listOf("one", "two", "three", "four").sortedDescending() }") 
    println("　")

    println("> Custom orders")
    println("listOf(\"one\", \"two\", \"three\", \"four\").sortedBy { it.length }  = ${ listOf("one", "two", "three", "four").sortedBy { it.length } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\").sortedByDescending { it.length }  = ${ listOf("one", "two", "three", "four").sortedByDescending { it.length } }") 
    println("　")

    println("> Custom orders:custom order for the collection sorting")
    println("listOf(\"one\", \"two\", \"three\", \"four\").sortedWith(compareBy { it.length })  = ${ listOf("one", "two", "three", "four").sortedWith(compareBy { it.length }) }") 
    println("　")

    println("> Reverse order")
    println("listOf(\"one\", \"two\", \"three\", \"four\").reversed()  = ${ listOf("one", "two", "three", "four").reversed() }") 
    println("　")

    println("> Random order")
    println("listOf(\"one\", \"two\", \"three\", \"four\").shuffled()  = ${ listOf("one", "two", "three", "four").shuffled() }") 

}

// 出力：
// ---ReadOnly List : Collection Ordering---
// > Natural order
// listOf("one", "two", "three", "four").sorted()  = [four, one, three, two]
// listOf("one", "two", "three", "four").sortedDescending()  = [two, three, one, four]
// 　
// > Custom orders
// listOf("one", "two", "three", "four").sortedBy { it.length }  = [one, two, four, three]
// listOf("one", "two", "three", "four").sortedByDescending { it.length }  = [three, four, one, two]
// 　
// > Custom orders:custom order for the collection sorting
// listOf("one", "two", "three", "four").sortedWith(compareBy { it.length })  = [one, two, four, three]
// 　
// > Reverse order
// listOf("one", "two", "three", "four").reversed()  = [four, three, two, one]
// 　
// > Random order
// listOf("one", "two", "three", "four").shuffled()  = [two, three, four, one]