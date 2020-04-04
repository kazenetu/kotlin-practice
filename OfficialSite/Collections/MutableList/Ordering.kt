
/*
 * コレクション：MutableList
 */
fun main() {

    // 並び替え
    println("---Mutable List : Collection Ordering---")

    println("> Natural order")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").sorted()  = ${ mutableListOf("one", "two", "three", "four").sorted() }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").sortedDescending()  = ${ mutableListOf("one", "two", "three", "four").sortedDescending() }") 
    println("　")

    println("> Custom orders")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").sortedBy { it.length }  = ${ mutableListOf("one", "two", "three", "four").sortedBy { it.length } }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").sortedByDescending { it.length }  = ${ mutableListOf("one", "two", "three", "four").sortedByDescending { it.length } }") 
    println("　")

    println("> Custom orders:custom order for the collection sorting")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").sortedWith(compareBy { it.length })  = ${ mutableListOf("one", "two", "three", "four").sortedWith(compareBy { it.length }) }") 
    println("　")

    println("> Reverse order")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").reversed()  = ${ mutableListOf("one", "two", "three", "four").reversed() }") 
    println("　")

    println("> Reverse order:all its changes reflect in its reversed") // 参照元のリストを反映した逆順ソート
    val numbers = mutableListOf("one", "two", "three", "four")
    val reversedNumbers = numbers.asReversed()
    println("reversedNumbers = mutableListOf(\"one\", \"two\", \"three\", \"four\").asReversed() : ${ reversedNumbers }") 
    numbers.add("five")
    println("numbers.add(\"five\")") 
    println("reversedNumbers = ${ reversedNumbers }") 
    println("　")

    println("> Random order")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").shuffled()  = ${ mutableListOf("one", "two", "three", "four").shuffled() }") 

}

// 出力：
// ---Mutable List : Collection Ordering---
// > Natural order
// mutableListOf("one", "two", "three", "four").sorted()  = [four, one, three, two]
// mutableListOf("one", "two", "three", "four").sortedDescending()  = [two, three, one, four]
// 　
// > Custom orders
// mutableListOf("one", "two", "three", "four").sortedBy { it.length }  = [one, two, four, three]
// mutableListOf("one", "two", "three", "four").sortedByDescending { it.length }  = [three, four, one, two]
// 　
// > Custom orders:custom order for the collection sorting
// mutableListOf("one", "two", "three", "four").sortedWith(compareBy { it.length })  = [one, two, four, three]
// 　
// > Reverse order
// mutableListOf("one", "two", "three", "four").reversed()  = [four, three, two, one]
// 　
// > Reverse order:all its changes reflect in its reversed
// reversedNumbers = mutableListOf("one", "two", "three", "four").asReversed() : [four, three, two, one]
// numbers.add("five")
// reversedNumbers = [five, four, three, two, one]
// 　
// > Random order
// mutableListOf("one", "two", "three", "four").shuffled()  = [four, three, one, two]