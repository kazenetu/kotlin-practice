/*
 * コレクション：MutableList
 */
fun main() {

    // 各要素へのアクセス
    println("---Mutable List : Access element---")
    val list = mutableListOf(1, 2, 3, 4)
    println("list = $list")
    println("　")

    println("> get element")
    println("list.get(0) = ${ list.get(0) }")
    println("list[0] = ${ list[0] }")
    println("　")

    println("> getOrNull")
    println("list.getOrNull(5) = ${ list.getOrNull(5) }")                 // getOrNull:要素インデックスが存在しない場合はnullを返す
    println("list.getOrNull(2) = ${ list.getOrNull(2) }")                 // getOrNull:要素インデックスが存在する場合は値を返す
    println("　")

    println("> getOrElse")
    println("list.getOrElse(2, {null}) = ${ list.getOrElse(2, {null}) }") // getOrElse:要素インデックスが存在する場合は値を返す
    println("list.getOrElse(5, {it}) = ${ list.getOrElse(5, {it}) }")     // getOrElse:要素インデックスが存在しない場合はit(5)を返す
    println("list.getOrElse(5, {null}) = ${ list.getOrElse(5, {null}) }") // getOrElse:要素インデックスが存在しない場合はnullを返す
    println("　")

    // リストの部分コピー(終了インデックス番号, 開始インデックス番号(含まない))
    println("---Mutable List : list parts---")
    println("mutableListOf(1, 2, 3, 4).subList(1, 3) = ${mutableListOf(1, 2, 3, 4).subList(1, 3)}")

}

// 出力：
// ---Mutable List : Access element---
// list = [1, 2, 3, 4]
// 　
// > get element
// list.get(0) = 1
// list[0] = 1
// 　
// > getOrNull
// list.getOrNull(5) = null
// list.getOrNull(2) = 3
// 　
// > getOrElse
// list.getOrElse(2, {null}) = 3
// list.getOrElse(5, {it}) = 5
// list.getOrElse(5, {null}) = null
// 　
// ---Mutable List : list parts---
// mutableListOf(1, 2, 3, 4).subList(1, 3) = [2, 3]
