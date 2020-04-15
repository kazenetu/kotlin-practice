/*
 * 高階関数
 * エントリポイント
 */
fun main() {
    // filter
    println("----filter----")
    println(listOf(1, 2, 3, 4, 5).filter{it % 2 == 0})
    val filterSourceData = listOf(1, "2", 3, 4.5, 5.0f, 6)
    println(filterSourceData.filter{it is String})
    println(filterSourceData.filter{it is Double})
    println(filterSourceData.filter{it is Int && it % 2 == 0})
    println("　")

    // map
    println("----map----")
    val mapSourceData = listOf("a", "b", "Hello, world!!!")
    println(mapSourceData.map{it.toUpperCase()})
    println("　")

    // forEach(戻り値はUnit)
    println("----forEach----")
    val forEachSourceData = listOf("a", "b", "Hello, world!!!")
    forEachSourceData.forEach{println(it)}
    println("　")

    // reduce
    println("----reduce----")
    println(listOf(1, 2, 3, 4, 5).reduce{a ,b -> a + b})
    println("　")

    // mixin
    println("----mixin----")
    val mixineData = listOf(1, 2, 3, 4, 5)
        .filter{ it % 2 == 0 }
        .reduce{ total,add -> total + add }
    println(mixinData)
}

// 出力：
// ----filter----
// [2, 4]
// [2]
// [4.5]
// [6]
// 　
// ----map----
// [A, B, HELLO, WORLD!!!]
// 　
// ----forEach----
// a
// b
// Hello, world!!!
// 　
// ----reduce----
// 15
// 　
// ----mixin----
// 6