/*
 * バイナリサーチ用データクラス
 */
data class UserInfo(val name: String, val age: Int)

/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 初期化
    println("---ReadOnly List:Initialize---")
    println("listOf(1, 2, 3, 4) = ${listOf(1, 2, 3, 4)}")
    println("List(10, {it}) = ${ List(10, {it}) }")
    println("List(10){it} = ${ List(10){it} }")
    println("(1..10).toList() = ${ (1..10).toList() }")
    println("emptyList<String>() = ${ emptyList<String>() }")

    // 追加・削除した新しいリストを作成
    println("---plus and minus Operators---")
    println("emptyList<String>() + \"ABC\" = ${ emptyList<String>() + "ABC" }")
    println("listOf(1, 2, 3, 4) - 1 = ${listOf(1, 2, 3, 4) - 1}")

    // 各要素へのアクセス
    println("---ReadOnly List:Access element---")
    val list = listOf(1, 2, 3, 4)
    println("list = $list")
    println("list.get(0) = ${ list.get(0) }")
    println("list[0] = ${ list[0] }")
    println("list[0] = ${ list[0] }")

    println("list.getOrNull(5) = ${ list.getOrNull(5) }")                 // getOrNull:要素インデックスが存在しない場合はnullを返す
    println("list.getOrElse(5, {it}) = ${ list.getOrElse(5, {it}) }")     // getOrElse:要素インデックスが存在しない場合はit(5)を返す
    println("list.getOrElse(5, {null}) = ${ list.getOrElse(5, {null}) }") // getOrElse:要素インデックスが存在しない場合はnullを返す

    println("list.getOrNull(2) = ${ list.getOrNull(2) }")                 // getOrNull:要素インデックスが存在する場合は値を返す
    println("list.getOrElse(2, {null}) = ${ list.getOrElse(2, {null}) }") // getOrElse:要素インデックスが存在する場合は値を返す

    // リストの部分コピー(終了インデックス番号, 開始インデックス番号(含まない))
    println("---ReadOnly List:list parts---")
    println("listOf(1, 2, 3, 4).subList(1, 3) = ${listOf(1, 2, 3, 4).subList(1, 3)}")

    // 要素インデックスを取得
    println("---ReadOnly List:Linear search---")
    println("listOf(1, 2, 3, 4, 1).indexOf(1) = ${listOf(1, 2, 3, 4, 1).indexOf(1)}")
    println("listOf(1, 2, 3, 4, 1).lastIndexOf(1) = ${listOf(1, 2, 3, 4, 1).lastIndexOf(1)}")

    println("listOf(1, 2, 3, 4, 1).indexOf(5) = ${listOf(1, 2, 3, 4, 1).indexOf(5)}")           // 存在しない場合は-1
    println("listOf(1, 2, 3, 4, 1).lastIndexOf(5) = ${listOf(1, 2, 3, 4, 1).lastIndexOf(5)}")   // 存在しない場合は-1
    
    // 条件一致の要素インデックスを取得
    println("---ReadOnly List:Comparator binary search---")
    val users = listOf(
        UserInfo("A",10),
        UserInfo("B",30),
        UserInfo("C",100)
    )
    println("users = $users")
    println("users.binarySearch(UserInfo(\"C\",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = ${ users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) }")



}

// 出力：
// ---ReadOnly List:Initialize---
// listOf(1, 2, 3, 4) = [1, 2, 3, 4]
// List(10, {it}) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// List(10){it} = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// (1..10).toList() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// emptyList<String>() = []
// ---plus and minus Operators---
// emptyList<String>() + "ABC" = [ABC]
// listOf(1, 2, 3, 4) - 1 = [2, 3, 4]
// ---ReadOnly List:Access element---
// list = [1, 2, 3, 4]
// list.get(0) = 1
// list[0] = 1
// list[0] = 1
// list.getOrNull(5) = null
// list.getOrElse(5, {it}) = 5
// list.getOrElse(5, {null}) = null
// list.getOrNull(2) = 3
// list.getOrElse(2, {null}) = 3
// ---ReadOnly List:list parts---
// listOf(1, 2, 3, 4).subList(1, 3) = [2, 3]
// ---ReadOnly List:Linear search---
// listOf(1, 2, 3, 4, 1).indexOf(1) = 0
// listOf(1, 2, 3, 4, 1).lastIndexOf(1) = 4
// listOf(1, 2, 3, 4, 1).indexOf(5) = -1
// listOf(1, 2, 3, 4, 1).lastIndexOf(5) = -1
// ---ReadOnly List:Comparator binary search---
// users = [UserInfo(name=A, age=10), UserInfo(name=B, age=30), UserInfo(name=C, age=100)]
// users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = 2