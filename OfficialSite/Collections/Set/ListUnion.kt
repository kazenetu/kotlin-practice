/*
 * コレクション：Set(重複を許さないList)
 */
fun main() {

    // リストの合成・交差・除外（結果はSetになる）
    println("---List union operation---")
    val list = listOf(1, 2, 3, 4)
    println("list = $list")
    println("　")

    println("> union")
    println("list union listOf(5, 6) = ${ list union listOf(5, 6) }")   // 合成
    println("list.union(listOf(5, 6)) = ${ list.union(listOf(5, 6)) }") // 合成
    println("list.union(listOf(4, 5)) = ${ list.union(listOf(4, 5)) }") // 合成：重複分あり
    println("　")

    println("> intersect")
    println("list intersect listOf(1, 4) = ${ list intersect listOf(1, 4) }")       // 交差
    println("list.intersect(setOlistOff(4, 1)) = ${ list.intersect(listOf(4, 1)) }")// 交差
    println("list.intersect(listOf(1, 5)) = ${ list.intersect(listOf(1, 5)) }")     // 交差：「交差なし」あり
    println("　")

    println("> subtract")
    println("list subtract listOf(1, 4) = ${ list subtract listOf(1, 4) }")   // 除外
    println("list.subtract(listOf(4, 1)) = ${ list.subtract(listOf(4, 1)) }") // 除外
    println("list.subtract(listOf(1, 5)) = ${ list.subtract(listOf(1, 5)) }") // 除外：「対象なし」あり
    println("　")

    println("> target set")
    println("list union setOf(5, 6) = ${ list union setOf(5, 6) }")         // 合成：セット
    println("list intersect setOf(1, 4) = ${ list intersect setOf(1, 4) }") // 交差：セット
    println("list subtract setOf(1, 4) = ${ list subtract setOf(1, 4) }")   // 除外：セット

}

// 出力：
// ---List union operation---
// list = [1, 2, 3, 4]
// 　
// > union
// list union listOf(5, 6) = [1, 2, 3, 4, 5, 6]
// list.union(listOf(5, 6)) = [1, 2, 3, 4, 5, 6]
// list.union(listOf(4, 5)) = [1, 2, 3, 4, 5]
// 　
// > intersect
// list intersect listOf(1, 4) = [1, 4]
// list.intersect(setOlistOff(4, 1)) = [1, 4]
// list.intersect(listOf(1, 5)) = [1]
// 　
// > subtract
// list subtract listOf(1, 4) = [2, 3]
// list.subtract(listOf(4, 1)) = [2, 3]
// list.subtract(listOf(1, 5)) = [2, 3, 4]
// 　
// > target set
// list union setOf(5, 6) = [1, 2, 3, 4, 5, 6]
// list intersect setOf(1, 4) = [1, 4]
// list subtract setOf(1, 4) = [2, 3]
