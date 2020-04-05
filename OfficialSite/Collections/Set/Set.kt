/*
 * コレクション：Set(重複を許さないList)
 */
fun main() {

    // 合成・交差・除外
    println("---Set : operations---")
    val set = setOf(1, 2, 3, 4)
    println("set = $set")
    println("　")

    println("> union")
    println("set union setOf(5, 6) = ${ set union setOf(5, 6) }")   // 合成
    println("set.union(setOf(5, 6)) = ${ set.union(setOf(5, 6)) }") // 合成
    println("set.union(setOf(4, 5)) = ${ set.union(setOf(4, 5)) }") // 合成：重複分あり
    println("　")

    println("> intersect")
    println("set intersect setOf(1, 4) = ${ set intersect setOf(1, 4) }")   // 交差
    println("set.intersect(setOf(4, 1)) = ${ set.intersect(setOf(4, 1)) }") // 交差
    println("set.intersect(setOf(1, 5)) = ${ set.intersect(setOf(1, 5)) }") // 交差：「交差なし」あり
    println("　")

    println("> subtract")
    println("set subtract setOf(1, 4) = ${ set subtract setOf(1, 4) }")   // 除外
    println("set.subtract(setOf(4, 1)) = ${ set.subtract(setOf(4, 1)) }") // 除外
    println("set.subtract(setOf(1, 5)) = ${ set.subtract(setOf(1, 5)) }") // 除外：「対象なし」あり
    println("　")

    println("> target list")
    println("set union listOf(5, 6) = ${ set union listOf(5, 6) }")         // 合成：リスト
    println("set intersect listOf(1, 4) = ${ set intersect listOf(1, 4) }") // 交差：リスト
    println("set subtract listOf(1, 4) = ${ set subtract listOf(1, 4) }")   // 除外：リスト

}

// 出力：
// ---Set : operations---
// set = [1, 2, 3, 4]
// 　
// > union
// set union setOf(5, 6) = [1, 2, 3, 4, 5, 6]
// set.union(setOf(5, 6)) = [1, 2, 3, 4, 5, 6]
// set.union(setOf(4, 5)) = [1, 2, 3, 4, 5]
// 　
// > intersect
// set intersect setOf(1, 4) = [1, 4]
// set.intersect(setOf(4, 1)) = [1, 4]
// set.intersect(setOf(1, 5)) = [1]
// 　
// > subtract
// set subtract setOf(1, 4) = [2, 3]
// set.subtract(setOf(4, 1)) = [2, 3]
// set.subtract(setOf(1, 5)) = [2, 3, 4]
// 　
// > target list
// set union listOf(5, 6) = [1, 2, 3, 4, 5, 6]
// set intersect listOf(1, 4) = [1, 4]
// set subtract listOf(1, 4) = [2, 3]
// 　
