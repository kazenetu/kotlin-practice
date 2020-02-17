/*
 * 最小クラス
 */
class Minimum

/*
 * 最小クラス：プロパティあり
 */
class MinimumExistsPrperty(val getOnlyProperty:String = "ABC", var setGetProperty: Int = 10)

/*
 * エントリポイント
 */
fun main() {

    // 最小クラス
    println("----Minimum Class---")
    val minimum = Minimum()
    println("minimum is $minimum")

    // 最小クラス：プロパティあり
    println("----Minimum class Exists Prperty---")
    val minimumExistsProp = MinimumExistsPrperty()
    println("getOnlyProperty is ${minimumExistsProp.getOnlyProperty}")
    println("setGetProperty is ${minimumExistsProp.setGetProperty}")
    // プロパティ変更
    minimumExistsProp.setGetProperty = 100
    println("update setGetProperty is ${minimumExistsProp.setGetProperty}")
}

// 出力：
// ----Minimum Class---
// minimum is Minimum@5ca881b5
// ----Minimum class Exists Prperty---
// getOnlyProperty is ABC
// setGetProperty is 10
// update setGetProperty is 100