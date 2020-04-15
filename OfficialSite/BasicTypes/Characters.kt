/*
 * ローカルフィールドの値と型を返す
 */
inline fun <reified T> getValueAndType(data:T): String {
    return "$data is ${T::class.java.simpleName}"
}

/*
 * 文字をIntに変換するメソッド
 */
fun convertIntValueZeroToNine(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("$c is not 0..9")
    }
    return c.toInt() - '0'.toInt()
}

/*
 * 基本型：文字型
 */
fun main() {

    // 文字
    println("---Characters---")
    val a = 'a'
    val one = '1'
    var c = "abc"[2]

    println(getValueAndType(a))
    println(getValueAndType(one))
    println(getValueAndType(c))
    println("　")

    // 文字をIntに変換
    println("---Character to Int---")
    try {
        val oneInt = convertIntValueZeroToNine(one)
        println(getValueAndType(oneInt))

        val errorCase = convertIntValueZeroToNine(a)
        println(getValueAndType(errorCase)) //実行されない
    } catch (e: Exception) {
        println(e)
    }
}

// 出力：
// ---Characters---
// a is Character
// 1 is Character
// c is Character
// 　
// ---Character to Int---
// 1 is Integer
// java.lang.IllegalArgumentException: a is not 0..9