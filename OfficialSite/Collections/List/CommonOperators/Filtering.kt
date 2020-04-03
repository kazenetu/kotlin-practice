/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")
    println("> Filtering : Filtering by predicate") // フィルタリング：基本
    println("listOf(\"one\", \"two\", \"three\", \"four\").filter{ it.length > 3 } = ${ listOf("one", "two", "three", "four").filter{ it.length > 3 } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").filter({ it.length > 3 }) = ${ listOf("one", "two", "three", "four").filter({ it.length > 3 }) }")
    println("　")

    println("> Filtering : Filtering by predicate : negative conditions") // フィルタリング：基本 否定条件
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterNot{ it.length > 3 } = ${ listOf("one", "two", "three", "four").filterNot{ it.length > 3 } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterNot({ it.length > 3 }) = ${ listOf("one", "two", "three", "four").filterNot({ it.length > 3 }) }")
    println("　")

    println("> Filtering : Filtering by predicate : use element positions") // フィルタリング：基本 要素インデックス使用
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } = ${ listOf("one", "two", "three", "four").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) = ${ listOf("one", "two", "three", "four").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) }")
    println("　")

    println("> Filtering : Filtering by predicate : elements of a given type") // フィルタリング：基本 対象の型のみ
    println("listOf(null, 1, \"two\", 3.0, \"four\").filterIsInstance<Int>() = ${ listOf(null, 1, "two", 3.0, "four").filterIsInstance<Int>() }")
    println("listOf(null, 1, \"two\", 3.0, \"four\").filterIsInstance<String>() = ${ listOf(null, 1, "two", 3.0, "four").filterIsInstance<String>() }")
    println("　")

    println("> Filtering : Filtering by predicate : non-null elements") // フィルタリング：基本 null以外
    println("listOf(null, 1, \"two\", 3.0, \"four\").filterNotNull() = ${ listOf(null, 1, "two", 3.0, "four").filterNotNull() }")
    println("　")

    println("> Filtering : Partitioning") // フィルタリング：条件一致/不一致リスト取得
    println("listOf(\"one\", \"two\", \"three\", \"four\").partition({ it.length > 3 }) = ${ listOf("one", "two", "three", "four").partition({ it.length > 3 }) }")
    val (match, rest) = listOf("one", "two", "three", "four").partition { it.length > 3 } // 一致と不一致の二つに分ける
    println("match = $match")
    println("rest = $rest")
    println("　")

    println("> Filtering : Testing predicates") // フィルタリング：条件一致の確認
    println("listOf(\"one\", \"two\", \"three\", \"four\").any({ it.endsWith(\"e\") }) = ${ listOf("one", "two", "three", "four").any({ it.endsWith("e") }) }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").none({ it.endsWith(\"e\") }) = ${ listOf("one", "two", "three", "four").none({ it.endsWith("e") }) }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").all({ it.endsWith(\"e\") }) = ${ listOf("one", "two", "three", "four").all({ it.endsWith("e") }) }")
    println("all[empty collection:true] emptyList<Int>().all { it > 5 } = ${ emptyList<Int>().all { it > 5 } }")
    println("　")

    println("> Filtering : Testing predicates : check the collection emptiness") // フィルタリング：コレクションの確認
    println("listOf(\"one\", \"two\", \"three\", \"four\").any() = ${ listOf("one", "two", "three", "four").any() }")
    println("emptyList<Int>().any() = ${ emptyList<Int>().any() }")
    println("listOf(\"one\", \"two\", \"three\", \"four\").none() = ${ listOf("one", "two", "three", "four").none() }")
    println("emptyList<Int>().none() = ${ emptyList<Int>().none() }")

}

// 出力：
// ---common Operators---
// > Filtering : Filtering by predicate
// listOf("one", "two", "three", "four").filter{ it.length > 3 } = [three, four]
// listOf("one", "two", "three", "four").filter({ it.length > 3 }) = [three, four]
// 　
// > Filtering : Filtering by predicate : negative conditions
// listOf("one", "two", "three", "four").filterNot{ it.length > 3 } = [one, two]
// listOf("one", "two", "three", "four").filterNot({ it.length > 3 }) = [one, two]
// 　
// > Filtering : Filtering by predicate : use element positions
// listOf("one", "two", "three", "four").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } = [two, four]
// listOf("one", "two", "three", "four").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) = [two, four]
// 　
// > Filtering : Filtering by predicate : elements of a given type
// listOf(null, 1, "two", 3.0, "four").filterIsInstance<Int>() = [1]
// listOf(null, 1, "two", 3.0, "four").filterIsInstance<String>() = [two, four]
// 　
// > Filtering : Filtering by predicate : non-null elements
// listOf(null, 1, "two", 3.0, "four").filterNotNull() = [1, two, 3.0, four]
// 　
// > Filtering : Partitioning
// listOf("one", "two", "three", "four").partition({ it.length > 3 }) = ([three, four], [one, two])
// match = [three, four]
// rest = [one, two]
// 　
// > Filtering : Testing predicates
// listOf("one", "two", "three", "four").any({ it.endsWith("e") }) = true
// listOf("one", "two", "three", "four").none({ it.endsWith("e") }) = false
// listOf("one", "two", "three", "four").all({ it.endsWith("e") }) = false
// all[empty collection:true] emptyList<Int>().all { it > 5 } = true
// 　
// > Filtering : Testing predicates : check the collection emptiness
// listOf("one", "two", "three", "four").any() = true
// emptyList<Int>().any() = false
// listOf("one", "two", "three", "four").none() = false
// emptyList<Int>().none() = true
