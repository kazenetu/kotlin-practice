/*
 * コレクション：Set(重複を許さないList)
 */
fun main() {

    // 初期化
    println("---Set:Initialize---")
    println("setOf(1, 2, 3, 4) = ${setOf(1, 2, 3, 4)}")
    println("(1..10).toSet() = ${ (1..10).toSet() }")
    println("emptySet<String>() = ${ emptySet<String>() }")

    // 合成・交差・除外
    println("---Set:operations---")
    val set = setOf(1, 2, 3, 4)
    println("set = $set")

    println("> union")
    println("set union setOf(5, 6) = ${ set union setOf(5, 6) }")   // 合成
    println("set.union(setOf(5, 6)) = ${ set.union(setOf(5, 6)) }") // 合成
    println("set.union(setOf(4, 5)) = ${ set.union(setOf(4, 5)) }") // 合成：重複分あり

    println("> intersect")
    println("set intersect setOf(1, 4) = ${ set intersect setOf(1, 4) }")   // 交差
    println("set.intersect(setOf(4, 1)) = ${ set.intersect(setOf(4, 1)) }") // 交差
    println("set.intersect(setOf(1, 5)) = ${ set.intersect(setOf(1, 5)) }") // 交差：「交差なし」あり

    println("> subtract")
    println("set subtract setOf(1, 4) = ${ set subtract setOf(1, 4) }")   // 除外
    println("set.subtract(setOf(4, 1)) = ${ set.subtract(setOf(4, 1)) }") // 除外
    println("set.subtract(setOf(1, 5)) = ${ set.subtract(setOf(1, 5)) }") // 除外：「対象なし」あり

    println("> target list")
    println("set union listOf(5, 6) = ${ set union listOf(5, 6) }")         // 合成：リスト
    println("set intersect listOf(1, 4) = ${ set intersect listOf(1, 4) }") // 交差：リスト
    println("set subtract listOf(1, 4) = ${ set subtract listOf(1, 4) }")   // 除外：リスト


    // リストの合成・交差・除外（結果はSetになる）
    println("---List union operation---")
    val list = listOf(1, 2, 3, 4)
    println("list = $list")

    println("> union")
    println("list union listOf(5, 6) = ${ list union listOf(5, 6) }")   // 合成
    println("list.union(listOf(5, 6)) = ${ list.union(listOf(5, 6)) }") // 合成
    println("list.union(listOf(4, 5)) = ${ list.union(listOf(4, 5)) }") // 合成：重複分あり

    println("> intersect")
    println("list intersect listOf(1, 4) = ${ list intersect listOf(1, 4) }")       // 交差
    println("list.intersect(setOlistOff(4, 1)) = ${ list.intersect(listOf(4, 1)) }")// 交差
    println("list.intersect(listOf(1, 5)) = ${ list.intersect(listOf(1, 5)) }")     // 交差：「交差なし」あり

    println("> subtract")
    println("list subtract listOf(1, 4) = ${ list subtract listOf(1, 4) }")   // 除外
    println("list.subtract(listOf(4, 1)) = ${ list.subtract(listOf(4, 1)) }") // 除外
    println("list.subtract(listOf(1, 5)) = ${ list.subtract(listOf(1, 5)) }") // 除外：「対象なし」あり

    println("> target set")
    println("list union setOf(5, 6) = ${ list union setOf(5, 6) }")         // 合成：セット
    println("list intersect setOf(1, 4) = ${ list intersect setOf(1, 4) }") // 交差：セット
    println("list subtract setOf(1, 4) = ${ list subtract setOf(1, 4) }")   // 除外：セット

}

// 出力：
// ---Set:Initialize---
// setOf(1, 2, 3, 4) = [1, 2, 3, 4]
// (1..10).toSet() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// emptySet<String>() = []
// ---Set:operations---
// set = [1, 2, 3, 4]
// > union
// set union setOf(5, 6) = [1, 2, 3, 4, 5, 6]
// set.union(setOf(5, 6)) = [1, 2, 3, 4, 5, 6]
// set.union(setOf(4, 5)) = [1, 2, 3, 4, 5]
// > intersect
// set intersect setOf(1, 4) = [1, 4]
// set.intersect(setOf(4, 1)) = [1, 4]
// set.intersect(setOf(1, 5)) = [1]
// > subtract
// set subtract setOf(1, 4) = [2, 3]
// set.subtract(setOf(4, 1)) = [2, 3]
// set.subtract(setOf(1, 5)) = [2, 3, 4]
// > target list
// set union listOf(5, 6) = [1, 2, 3, 4, 5, 6]
// set intersect listOf(1, 4) = [1, 4]
// set subtract listOf(1, 4) = [2, 3]
// ---List union operation---
// list = [1, 2, 3, 4]
// > union
// list union listOf(5, 6) = [1, 2, 3, 4, 5, 6]
// list.union(listOf(5, 6)) = [1, 2, 3, 4, 5, 6]
// list.union(listOf(4, 5)) = [1, 2, 3, 4, 5]
// > intersect
// list intersect listOf(1, 4) = [1, 4]
// list.intersect(setOlistOff(4, 1)) = [1, 4]
// list.intersect(listOf(1, 5)) = [1]
// > subtract
// list subtract listOf(1, 4) = [2, 3]
// list.subtract(listOf(4, 1)) = [2, 3]
// list.subtract(listOf(1, 5)) = [2, 3, 4]
// > target set
// list union setOf(5, 6) = [1, 2, 3, 4, 5, 6]
// list intersect setOf(1, 4) = [1, 4]
// list subtract setOf(1, 4) = [2, 3]