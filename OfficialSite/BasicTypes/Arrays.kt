/*
 * ローカルフィールドの値と型を返す
 */
inline fun <reified T> getValueAndType(data:T): String {
    return "$data is ${T::class.java.simpleName}"
}

/*
 * 基本型：配列型
 */
fun main() {

    // 配列型
    println("---Arrays---")
    val arrayStrings = Array(5) { i -> (i * i).toString() }
    println(getValueAndType(arrayStrings))
    arrayStrings.forEach { println(getValueAndType(it)) }
    println("　")

    // 配列型:生成:arrayOf
    println("---create method : arrayOf---")
    val arrayOfStrings = arrayOf("1","B")
    println(getValueAndType(arrayOfStrings))
    arrayOfStrings.forEach { println(getValueAndType(it)) }
    println("　")

    // 配列型:生成:プリミティブ型(Arrayと異なるが同じメソッド・プロパティあり)
    println("---create method : Primitive type arrays---")
    println("> intArrayOf(1, 2, 3):")
    var intArray = intArrayOf(1, 2, 3)
    println(getValueAndType(intArray))
    intArray.forEach { println(getValueAndType(it)) }
    println("　")

    println("> IntArray(5):")
    var intArrayZero = IntArray(5)
    println(getValueAndType(intArrayZero))
    intArrayZero.forEach { println(getValueAndType(it)) }
    println("　")

    println("> IntArray(5){42}:")
    var intArrayAll42 = IntArray(5){42}
    println(getValueAndType(intArrayAll42))
    intArrayAll42.forEach { println(getValueAndType(it)) }
    println("　")

    println("> IntArray(5){it + 1}:")
    var intArrays = IntArray(5){it + 1}
    println(getValueAndType(intArrays))
    intArrays.forEach { println(getValueAndType(it)) }

}

// 出力：
// ---Arrays---
// [Ljava.lang.String;@2f92e0f4 is String[]
// 0 is String
// 1 is String
// 4 is String
// 9 is String
// 16 is String
// 　
// ---create method : arrayOf---
// [Ljava.lang.String;@28a418fc is String[]
// 1 is String
// B is String
// 　
// ---create method : Primitive type arrays---
// > intArrayOf(1, 2, 3):
// [I@5305068a is int[]
// 1 is Integer
// 2 is Integer
// 3 is Integer
// 　
// > IntArray(5):
// [I@1f32e575 is int[]
// 0 is Integer
// 0 is Integer
// 0 is Integer
// 0 is Integer
// 0 is Integer
// 　
// > IntArray(5){42}:
// [I@279f2327 is int[]
// 42 is Integer
// 42 is Integer
// 42 is Integer
// 42 is Integer
// 42 is Integer
// 　
// > IntArray(5){it + 1}:
// [I@2ff4acd0 is int[]
// 1 is Integer
// 2 is Integer
// 3 is Integer
// 4 is Integer
// 5 is Integer