/*
 * 基本型：ブール型
 */
fun main() {

    // ブール型
    println("---Booleans---")
    val trueValue = true
    val falseValue = false

    println("trueValue = $trueValue")
    println("falseValue = $falseValue")

    // 操作
    println("---Built in operations---")
    println("trueValue && falseValue = ${trueValue && falseValue}")
    println("trueValue || falseValue = ${trueValue || falseValue}")
    println("!trueValue = ${!trueValue}")
}

// 出力：
// ---Booleans---
// trueValue = true
// falseValue = false
// ---Built in operations---
// trueValue && falseValue = false
// trueValue || falseValue = true
// !trueValue = false