// コレクションの別名設定
typealias Strings = MutableList<String>
typealias StringKeyMap<V> = MutableMap<String, V>

// メソッドの別名設定
typealias Callback = (text:String) -> Unit
typealias Equals = (string1:String, string2:String) -> Boolean
typealias Predicate<T> = (T) -> Boolean

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
    println("　")

    // メソッドの別名
    println("---Typealiases Method---")
    val callback:Callback = { println("Callback $it") }
    callback("ABC")
    "123".run(callback)
    fun localMethod(value: String, c: Callback) {
        c(value)
    }
    localMethod("DEF"){ println("call localMethod Callback $it") }

    val equals:Equals = { string1,string2 -> string1 == string2 }
    println("equals(\"a\",\"a\") = ${equals("a","a")}")
    
    val predicateInt:Predicate<Int> = {it < 10}
    val predicateSource = (1..100)
    println("$predicateSource.filter(predicateInt) = {predicateSource.filter(predicateInt)}")

}

// 出力：
// ---Typealiases Collection---
// stringList = [A, B, C]
// StringKeyMap<Int> = {A=100, B=1000}
// 　
// ---Typealiases Method---
// Callback ABC
// Callback 123
// call localMethod Callback DEF
// equals("a","a") = true
// 1..100.filter(predicateInt) = {predicateSource.filter(predicateInt)}