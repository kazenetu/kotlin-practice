/*
 * ローカルフィールドの値と型を返す
 */
inline fun <reified T> getValueAndType(data:T): String {
    return "$data is ${T::class.java.simpleName}"
}

/*
 * 基本型：数値
 */
fun main() {

    // 数値
    println("---Numbers---")
    val byte:Byte = 1
    val short:Short = 1
    val int = 1
    val long = 1L
    val float = 0.25f
    val double = 0.125
    val hexadecimal = 0xFF
    val binary = 0b00001011

    println(getValueAndType(byte))
    println(getValueAndType(short))
    println(getValueAndType(int))
    println(getValueAndType(long))
    println(getValueAndType(float))
    println(getValueAndType(double))
    println(getValueAndType(hexadecimal))
    println(getValueAndType(binary))
    println("　")

    // アンダースコアで表現した数値
    println("---Underscores in Numbers---")
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    println(getValueAndType(oneMillion))
    println(getValueAndType(creditCardNumber))
    println(getValueAndType(socialSecurityNumber))
    println(getValueAndType(hexBytes))
    println(getValueAndType(bytes))
    println("　")

    // 変換メソッド
    println("---convert method---")
    println(getValueAndType(byte.toShort()))
    println(getValueAndType(short.toByte()))
    println(getValueAndType(int.toLong()))
    println(getValueAndType(long.toInt()))
    println(getValueAndType(float.toDouble()))
    println(getValueAndType(double.toFloat()))
    println("　")

    // 割り算
    println("---Division of integers---")
    println(getValueAndType(5/2))
    println(getValueAndType(5L/2))
    println(getValueAndType(5.0/2))
}

// 出力：
// ---Numbers---
// 1 is Byte 
// 1 is Short
// 1 is Integer
// 1 is Long
// 0.25 is Float
// 0.125 is Double
// 255 is Integer
// 11 is Integer
// 　
// ---Underscores in Numbers---
// 1000000 is Integer
// 1234567890123456 is Long
// 999999999 is Long
// 4293713502 is Long
// 3530134674 is Long
// 　
// ---convert method---
// 1 is Short
// 1 is Byte
// 1 is Long
// 1 is Integer
// 0.25 is Double
// 0.125 is Float
// 　
// ---Division of integers---
// 2 is Integer
// 2 is Long
// 2.5 is Double