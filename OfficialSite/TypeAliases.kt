// コレクションの別名設定
typealias Strings = MutableList<String>
typealias StringKeyMap<V> = MutableMap<String, V>

/*
 * 基本型：別名設定
 */
fun main() {

    // コレクションの別名
    println("---Typealiases Collection---")
    val stringList: Strings = mutableListOf("A", "B")
    stringList.add("C")
    println("stringList = $stringList")

    val map: StringKeyMap<Int> = mutableMapOf<String,Int>()
    map.put("A", 100)
    map.put("B", 1000)
    println("StringKeyMap<Int> = $map")
}

// 出力：
// ---Typealiases Collection---
// stringList = [A, B, C]
// StringKeyMap<Int> = {A=100, B=1000}