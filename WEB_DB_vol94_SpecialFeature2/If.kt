/*
 * パラメータの値によって文字列を返す
 */
fun moreThan5(value: Int) = if(value > 5)  "$value > 5" else "$value <= 5"

/*
 * パラメータがIntであるか確認
 */
fun isInt(target: Any): Boolean {
    // if式を返す
    return if(target is Int) {
        true
    }
    else{
	    false
    }
}

/*
 * エントリポイント
 */
fun main() {
    val localInt = 10

    // 分岐
    println("----Local if statement---")
    if(localInt > 5) {
        println("$localInt > 5")
    }
    else {
        println("$localInt <= 5")
    }

    // ローカルフィールドにif式を設定
    println("----set if statement---")
    val localAny = localInt as Any
    val isString = if(localAny is String) true else false
    println(isString)

    // 範囲指定
    println("----if range statement ---")
    val value = 5
    val checkStartValue = 1
    val checkEndValue = 5
    if(value in checkStartValue..checkEndValue) {
        println("hit $value!")
    }

    // 範囲指定 否定
    println("----if range statement not in---")
    if(value !in 6..10) {
        println("not hit $value!")
    }


    // メソッド呼び出し
    println("----call method1---")
    println(moreThan5(6))
    println(moreThan5(5))

    // ブロックの最後が戻り値のメソッド呼び出し
    println("----call method2---")
    println(isInt(6))
    println(isInt("ABC"))
}

// 出力：
// ----Local if statement---
// 10 > 5
// ----set if statement---
// false
// ----if range statement ---
// hit 5!
// ----if range statement not in---
// not hit 5!
// ----call method1---
// 6 > 5
// 5 <= 5
// ----call method2---
// true
// false