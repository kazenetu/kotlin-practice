/*
 * クロージャー例：メソッド内ローカルフィールドのインクリメント
 */
fun incrementClosure(): ()->Int {
    var count:Int = 0
    return fun(): Int {
        return ++count
    }
}

//-------------------------
/*
 * クロージャー例：パラメータの値の参照
 */
fun addClosure(a:Int): (Int)->Int {
    return fun(b:Int) :Int {
        return a + b
    }
}

//-------------------------
/*
 * エントリポイント
 */
fun main() {
    // メソッド内ローカルフィールドのインクリメント
    println("----inner var increment closure----")
    val iClosure = incrementClosure()
    println(iClosure())
    println(iClosure())
    println(iClosure())
    println("　")

    // パラメータの値の参照
    println("----return function closure----")
    val aClosure = addClosure(10)
    println(aClosure(5))
    println("　")

    // ラムダ：範囲対象外のローカルフィールドの更新
    println("----lamda closure----")
    var sum: Int = 0;
    listOf(1, 2, 3, 4, 5, 6).forEach {
        sum += it
    }
    println(sum)
}

// 出力：
// ----inner var increment closure----
// 1
// 2
// 3
// 　
// ----return function closure----
// 15
// 　
// ----lamda closure----
// 21