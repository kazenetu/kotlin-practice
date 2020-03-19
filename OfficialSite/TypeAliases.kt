// コレクションの別名設定
typealias Strings = MutableList<String>
typealias StringKeyMap<V> = MutableMap<String, V>

// メソッドの別名設定
typealias Callback = (text:String) -> Unit
typealias Equals = (string1:String, string2:String) -> Boolean

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

    // メソッドの別名
    println("---Typealiases Method---")
    val callback:Callback = { println("Callback $it") }
    callback("ABC")
    val equals:Equals = { string1,string2 -> string1 == string2 }
    println("equals(\"a\",\"a\") = ${equals("a","a")}")

}

// 出力：
// ---Typealiases Collection---
// stringList = [A, B, C]
// StringKeyMap<Int> = {A=100, B=1000}
// ---Typealiases Method---
// Callback ABC
// equals("a","a") = true