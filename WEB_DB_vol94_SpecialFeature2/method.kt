/*
 * 戻り値なし
 */
fun noReturn(): Unit {
    println("NoReturn")
}

/*
 * 戻り値なし(型なし)
 */
fun NoReturnUnitLess() {
    println("noReturnUnitLess")
}

/*
 * 二つの値を足した値を返す
 */
fun add(a: Int,b: Int): Int {
    return a + b
}

/*
 * 二つの値を掛けた値を返す
 */
fun multiplication(a: Int,b: Int) = a * b

/*
 * 文字列の長さを取得する
 * nullの場合は0を返す
 */
fun length(src: String?) = src?.count() ?: 0

/*
 * パラメータが文字列であるか確認
 */
fun isString(src: Any) = if(src is String) true else false

/*
 * パラメータが数値であるか確認
 */
fun isInt(src: Any) = src is Int

/*
 * デフォルトパラメータ
 */
fun defaultArg(name: String = "noname") {
    println("Hello, $name!")
}

/*
 * 複数のデフォルトパラメータ
 */
fun defaultArgs(greeting:String = "Hello", name: String = "noname") {
    println("$greeting, $name!")
}

/*
 * メソッド実行
 */
fun main() {
    // 戻り値なし
    println("----noReturn---")
    noReturn()
    NoReturnUnitLess()

    // 計算結果を返す
    println("----add multiplication---")
    println(add(3, 2))
    println(multiplication(3, 2))

    // null許容、エルビス演算子
    println("----length---")
    println(length("ABC"))
    println(length(null))

    // パラメータが文字列か確認
    println("----isString---")
    println(isString("ABC"))
    println(isString(1))

    // パラメータが数値か確認
    println("----isInt---")
    println(isInt("ABC"))
    println(isInt(1))

    // デフォルトパラメータ
    println("----defaultArg---")
    defaultArg("kotlin")
    defaultArg()

    // 複数のデフォルトパラメータ
    println("----defaultArgs---")
    defaultArgs()
    defaultArgs("Thanks","kotlin")
    defaultArgs(name = "kotlin")

    // ローカルメソッド
    println("----localMethod---")
    fun localMethod() = "localMethod"
    println(localMethod())
}

// 出力：
// ----noReturn---
// NoReturn
// noReturnUnitLess
// ----add multiplication---
// 5
// 6
// ----length---
// 3
// 0
// ----isString---
// true
// false
// ----isInt---
// false
// true
// ----defaultArg---
// Hello, kotlin!
// Hello, noname!
// ----localMethod---
// localMethod