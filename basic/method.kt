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