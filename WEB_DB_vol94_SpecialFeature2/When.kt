/*
 * when式の確認
 */
fun main() {
    // src list
    val value = 10

    // when式
    println("----when statement---")
    when(value % 2) {
        0 -> {
            println("even $value")
        }
        else -> {
            println("odd $value")
        }
    }

    // when式を使ったメソッド(値を返す場合はelse必須)
    println("----when method---")
    fun isOdd(target: Int) = 
        when(target % 2){
            1 -> true
            else -> false
        }
    if(isOdd(value)) {
        println("odd $value")
    }
    else {
        println("even $value")
    }

    // when式のマッチング
    println("----when matching range and call method---")
    fun addTwo(intValue: Int) = intValue + 2
    when(value) {
        in 1..5 -> {
            println("range 1..5 $value")
        }
        addTwo(8) -> {
            println("8+2 = $value")
        }
        else -> {
            println("other $value")
        }
    }

    // 型のマッチングのwhen式
    println("----when matching types---")
    fun printType(target: Any) {
        when(target) {
            is String -> {
                println("$target is String")
            }
            is Int -> {
                println("$target is Int")
            }
            else -> {
                println("other type $target")
            }
        }
    }
    printType("ABC")
    printType(123)
    printType(listOf(1, 2, 3))

    // 値を渡さないwhen式
    println("----non set value---")
    fun printTypeNonSetValue(target: Any) {
        when {
            target is String -> {
                println("$target is String")
            }
            target is Int -> {
                println("$target is Int")
            }
            else -> {
                println("other type $target")
            }
        }
    }
    printTypeNonSetValue("ABC")
    printTypeNonSetValue(123)
    printTypeNonSetValue(listOf(1, 2, 3))

}

// 出力：
// ----when statement---
// even 10
// ----when method---
// even 10
// ----when matching range and call method---
// 8+2 = 10
// ----when matching types---
// ABC is String
// 123 is Int
// other type [1, 2, 3]
// ----non set value---
// ABC is String
// 123 is Int
// other type [1, 2, 3]