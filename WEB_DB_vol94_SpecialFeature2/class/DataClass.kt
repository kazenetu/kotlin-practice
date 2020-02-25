/*
 * データクラス
 * abstract, open, sealed または innerにできない
 */
data class DataClass(val name: String, val age: Int)

/*
 * データクラス用インターフェイス
 */
interface Interface {
    val name: String
    val age: Int

    /*
     * デフォルト実装：自身とプロパティを出力
    */
    fun print() {
        println("$this, $name,$age")
    }
}

/*
 * データクラス：インターフェイス継承
 */
data class DataClassInheritInterface(override val name: String, override val age: Int): Interface

/*
 * エントリポイント
 */
fun main() {

    // データクラス
    println("----DataClass---")
    val dataClass = DataClass("ABC", 10)
    println("$dataClass")
    println("dataClass == DataClass(\"ABC\", 10): ${dataClass == DataClass("ABC", 10)}")
    println("dataClass == DataClass(\"ABC\", 20): ${dataClass == DataClass("ABC", 20)}")

    // データクラス：インターフェイス継承
    println("----DataClassInheritInterface---")
    val dataClassInheritInterface = DataClassInheritInterface("DEF", 100)
    dataClassInheritInterface.print()
    println("dataClassInheritInterface == DataClassInheritInterface(\"DEF\", 100): ${dataClassInheritInterface == DataClassInheritInterface("DEF", 100)}")
    println("dataClassInheritInterface == DataClassInheritInterface(\"ABC\", 100): ${dataClassInheritInterface == DataClassInheritInterface("ABC", 100)}")

}

// 出力：
// ----DataClass---
// DataClass(name=ABC, age=10)
// dataClass == DataClass("ABC", 10): true
// dataClass == DataClass("ABC", 20): false
// ----DataClassInheritInterface---
// DataClassInheritInterface(name=DEF, age=100), DEF,100
// dataClassInheritInterface == DataClassInheritInterface("DEF", 100): true
// dataClassInheritInterface == DataClassInheritInterface("ABC", 100): false