/*
 * for構文の確認
 */
fun main() {
    // src list
    val items = listOf(1,2,3,4)

    // for構文：インスタンス
    println("----for statement item---")
    var itemTotal = 0
    for(item in items) {
        println("item is $item")
        itemTotal += item
    }
    println("total $itemTotal")

    // for構文：インデックス
    println("----for statement index---")
    itemTotal = 0
    for(index in items.indices) {
        println("items[$index] is ${items[index]}")
        itemTotal += items[index]
    }
    println("total $itemTotal")
}

// 出力：
// ----for statement item---
// item is 1
// item is 2
// item is 3
// item is 4
// total 10
// ----for statement index---
// items[0] is 1
// items[1] is 2
// items[2] is 3
// items[3] is 4
// total 10
