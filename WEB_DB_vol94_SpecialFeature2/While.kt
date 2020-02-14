/*
 * while構文の確認
 */
fun main() {
    // src list
    val items = listOf(1,2,3,4)

    // while構文：インデックス
    println("----while statement---")
    var itemTotal = 0
    var index = 0
    while(index < items.size) {
        println("items[$index] is ${items[index]}")
        itemTotal += items[index]
        index++
    }
    println("total $itemTotal")
}

// 出力：
// ----while statement---
// items[0] is 1
// items[1] is 2
// items[2] is 3
// items[3] is 4
// total 10