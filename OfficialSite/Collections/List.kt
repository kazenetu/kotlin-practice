/*
 * バイナリサーチ用データクラス
 */
data class UserInfo(val name: String, val age: Int)

/*
 * 変換：平坦化用データクラス
 */
data class StringContainer(val values: List<String>)

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
    println("listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)) = ${ listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)) }")

    // 基本的な操作
    println("---common Operators---")

    println("> plus and minus Operators")   //リストの追加と削除を生成
    println("emptyList<String>() + \"ABC\" = ${ emptyList<String>() + "ABC" }")
    println("listOf(1, 2, 3, 4) - 1 = ${listOf(1, 2, 3, 4) - 1}")

    println("> isEmpty") // リストの空チェック
    println("emptyList<String>().isEmpty() = ${ emptyList<String>().isEmpty() }")
    println("listOf(1, 2, 3, 4).isEmpty() = ${listOf(1, 2, 3, 4).isEmpty()}")

    println("> Transformations:Flattening") // 変換：平坦化
    println("listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)).flatten() = ${ listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)).flatten() }")
    val stringContainers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println("stringContainers = $stringContainers")
    println("stringContainers.flatMap { it.values } = ${stringContainers.flatMap { it.values }}") // データクラスでの平坦化

    println("> Transformations:String representation") // 変換：コレクションの文字列化
    println("listOf(\"one\", \"two\", \"three\").joinToString() = ${ listOf("one", "two", "three").joinToString() }")
    println("listOf(\"one\", \"two\", \"three\").joinToString(separator = \" | \", prefix = \"start: \", postfix = \": end\") = ${ listOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\") = ${ listOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>") }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\", separator = \" \") = ${ listOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>", separator = " ") }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString { \"<\${it.toUpperCase()}>\" } = ${ listOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").joinToString(transform = { \"<\${it.toUpperCase()}>\" }) = ${ listOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) }")

    val stringBuffer = StringBuffer("The list of numbers: ") // バッファにコピー
    listOf("one", "two", "three").joinTo(stringBuffer)
    println("listOf(\"one\", \"two\", \"three\").joinTo(stringBuffer) = $stringBuffer")

    println("> Filtering:Filtering by predicate") // フィルタリング：基本
    println("listOf(\"one\", \"two\", \"three\", \"four\").filter{ it.length > 3 } = ${ listOf("one", "two", "three", "four").filter{ it.length > 3 } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").filter({ it.length > 3 }) = ${ listOf("one", "two", "three", "four").filter({ it.length > 3 }) }")

    println("> Filtering:Filtering by predicate:negative conditions") // フィルタリング：基本 否定条件
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterNot{ it.length > 3 } = ${ listOf("one", "two", "three", "four").filterNot{ it.length > 3 } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterNot({ it.length > 3 }) = ${ listOf("one", "two", "three", "four").filterNot({ it.length > 3 }) }")

    println("> Filtering:Filtering by predicate:use element positions") // フィルタリング：基本 要素インデックス使用
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } = ${ listOf("one", "two", "three", "four").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) = ${ listOf("one", "two", "three", "four").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) }")

    println("> Filtering:Filtering by predicate:elements of a given type") // フィルタリング：基本 対象の型のみ
    println("listOf(null, 1, \"two\", 3.0, \"four\").filterIsInstance<Int>() = ${ listOf(null, 1, "two", 3.0, "four").filterIsInstance<Int>() }")
    println("listOf(null, 1, \"two\", 3.0, \"four\").filterIsInstance<String>() = ${ listOf(null, 1, "two", 3.0, "four").filterIsInstance<String>() }")

    println("> Filtering:Filtering by predicate:non-null elements") // フィルタリング：基本 null以外
    println("listOf(null, 1, \"two\", 3.0, \"four\").filterNotNull() = ${ listOf(null, 1, "two", 3.0, "four").filterNotNull() }")

    println("> Filtering:Partitioning") // フィルタリング：条件一致/不一致リスト取得
    println("listOf(\"one\", \"two\", \"three\", \"four\").partition({ it.length > 3 }) = ${ listOf("one", "two", "three", "four").partition({ it.length > 3 }) }")
    val (match, rest) = listOf("one", "two", "three", "four").partition { it.length > 3 } // 一致と不一致の二つに分ける
    println("match = $match")
    println("rest = $rest")

    println("> Filtering:Testing predicates") // フィルタリング：条件一致の確認
    println("listOf(\"one\", \"two\", \"three\", \"four\").any({ it.endsWith(\"e\") }) = ${ listOf("one", "two", "three", "four").any({ it.endsWith("e") }) }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").none({ it.endsWith(\"e\") }) = ${ listOf("one", "two", "three", "four").none({ it.endsWith("e") }) }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").all({ it.endsWith(\"e\") }) = ${ listOf("one", "two", "three", "four").all({ it.endsWith("e") }) }")
    println("all[empty collection:true] emptyList<Int>().all { it > 5 } = ${ emptyList<Int>().all { it > 5 } }")

    println("> Filtering:Testing predicates:check the collection emptiness") // フィルタリング：コレクションの確認
    println("listOf(\"one\", \"two\", \"three\", \"four\").any() = ${ listOf("one", "two", "three", "four").any() }")
    println("emptyList<Int>().any() = ${ emptyList<Int>().any() }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").none() = ${ listOf("one", "two", "three", "four").none() }")
    println("emptyList<Int>().none() = ${ emptyList<Int>().none() }")


    // 各要素へのアクセス
    println("---ReadOnly List:Access element---")
    val list = listOf(1, 2, 3, 4)
    println("list = $list")

    println("> get element")
    println("list.get(0) = ${ list.get(0) }")
    println("list[0] = ${ list[0] }")
    println("list[0] = ${ list[0] }")

    println("> getOrNull")
    println("list.getOrNull(5) = ${ list.getOrNull(5) }")                 // getOrNull:要素インデックスが存在しない場合はnullを返す
    println("list.getOrNull(2) = ${ list.getOrNull(2) }")                 // getOrNull:要素インデックスが存在する場合は値を返す

    println("> getOrNull")
    println("list.getOrElse(5, {it}) = ${ list.getOrElse(5, {it}) }")     // getOrElse:要素インデックスが存在しない場合はit(5)を返す
    println("list.getOrElse(5, {null}) = ${ list.getOrElse(5, {null}) }") // getOrElse:要素インデックスが存在しない場合はnullを返す
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
// listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)) = [[1, 2, 3, 4], [10, 20, 30, 40]]
// ---common Operators---
// > plus and minus Operators
// emptyList<String>() + "ABC" = [ABC]
// listOf(1, 2, 3, 4) - 1 = [2, 3, 4]
// > isEmpty
// emptyList<String>().isEmpty() = true
// listOf(1, 2, 3, 4).isEmpty() = false
// > Transformations:Flattening
// listOf(listOf(1, 2, 3, 4), listOf(10, 20, 30, 40)).flatten() = [1, 2, 3, 4, 10, 20, 30, 40]
// stringContainers = [StringContainer(values=[one, two, three]), StringContainer(values=[four, five, six]), StringContainer(values=[seven, eight])]
// stringContainers.flatMap { it.values } = [one, two, three, four, five, six, seven, eight]
// > Transformations:String representation
// listOf("one", "two", "three").joinToString() = one, two, three
// listOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") = start: one | two | three: end
// listOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>") = one, two, three, <next...>
// listOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>", separator = " ") = one two three <next...>
// listOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } = <ONE>, <TWO>, <THREE>, <FOUR>
// listOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) = <ONE>, <TWO>, <THREE>, <FOUR>
// listOf("one", "two", "three").joinTo(stringBuffer) = The list of numbers: one, two, three
// > Filtering:Filtering by predicate
// listOf("one", "two", "three", "four").filter{ it.length > 3 } = [three, four]
// listOf("one", "two", "three", "four").filter({ it.length > 3 }) = [three, four]
// > Filtering:Filtering by predicate:negative conditions
// listOf("one", "two", "three", "four").filterNot{ it.length > 3 } = [one, two]
// listOf("one", "two", "three", "four").filterNot({ it.length > 3 }) = [one, two]
// > Filtering:Filtering by predicate:use element positions
// listOf("one", "two", "three", "four").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } = [two, four]
// listOf("one", "two", "three", "four").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) = [two, four]
// > Filtering:Filtering by predicate:elements of a given type
// listOf(null, 1, "two", 3.0, "four").filterIsInstance<Int>() = [1]
// listOf(null, 1, "two", 3.0, "four").filterIsInstance<String>() = [two, four]
// > Filtering:Filtering by predicate:non-null elements
// listOf(null, 1, "two", 3.0, "four").filterNotNull() = [1, two, 3.0, four]
// > Filtering:Partitioning
// listOf("one", "two", "three", "four").partition({ it.length > 3 }) = ([three, four], [one, two])
// match = [three, four]
// rest = [one, two]
// > Filtering:Testing predicates
// listOf("one", "two", "three", "four").any({ it.endsWith("e") }) = true
// listOf("one", "two", "three", "four").none({ it.endsWith("e") }) = false
// listOf("one", "two", "three", "four").all({ it.endsWith("e") }) = false
// all[empty collection:true] emptyList<Int>().all { it > 5 } = true
// > Filtering:Testing predicates:check the collection emptiness
// listOf("one", "two", "three", "four").any() = true
// emptyList<Int>().any() = false
// listOf("one", "two", "three", "four").none() = false
// emptyList<Int>().none() = true
// ---ReadOnly List:Access element---
// list = [1, 2, 3, 4]
// > get element
// list.get(0) = 1
// list[0] = 1
// list[0] = 1
// > getOrNull
// list.getOrNull(5) = null
// list.getOrNull(2) = 3
// > getOrNull
// list.getOrElse(5, {it}) = 5
// list.getOrElse(5, {null}) = null
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