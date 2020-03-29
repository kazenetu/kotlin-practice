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

    println("> isNotEmpty") // リストの要素ありチェック
    println("emptyList<String>().isNotEmpty() = ${ emptyList<String>().isNotEmpty() }")
    println("listOf(1, 2, 3, 4).isNotEmpty() = ${listOf(1, 2, 3, 4).isNotEmpty()}")

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

    println("> Retrieving Collection Parts:Slice") // コレクションパーツの取得：要素インデックス指定の部分取り出し
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(1..3) = ${ listOf("one", "two", "three", "four", "five", "six").slice(1..3) }")                     // 範囲指定
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(0..4 step 2) = ${ listOf("one", "two", "three", "four", "five", "six").slice(0..4 step 2) }")       // 範囲指定：飛び番
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(setOf(3, 5, 0)) = ${ listOf("one", "two", "three", "four", "five", "six").slice(setOf(3, 5, 0)) }") // 範囲指定：インデックス指定

    println("> Retrieving Collection Parts:Take") // コレクションパーツの取得：要素インデックス数指定で前後の部分取り出し
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").take(3) = ${ listOf("one", "two", "three", "four", "five", "six").take(3) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeLast(3) = ${ listOf("one", "two", "three", "four", "five", "six").takeLast(3) }") 

    println("> Retrieving Collection Parts:Drop") // コレクションパーツの取得：要素インデックス数指定で前後の要素の除外
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").drop(2) = ${ listOf("one", "two", "three", "four", "five", "six").drop(2) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropLast(5) = ${ listOf("one", "two", "three", "four", "five", "six").dropLast(5) }") 

    println("> Retrieving Collection Parts:TakeWhile") // コレクションパーツの取得：条件を満たすまでの要素の部分取り出し
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeWhile { !it.startsWith('f') } = ${ listOf("one", "two", "three", "four", "five", "six").takeWhile { !it.startsWith('f') } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeLastWhile { it != \"three\" } = ${ listOf("one", "two", "three", "four", "five", "six").takeLastWhile { it != "three" } }") 

    println("> Retrieving Collection Parts:DropWhile") // コレクションパーツの取得：条件を満たすまでの要素の除外
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropWhile { it.length == 3 } = ${ listOf("one", "two", "three", "four", "five", "six").dropWhile { it.length == 3 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropLastWhile { it.contains('i') } = ${ listOf("one", "two", "three", "four", "five", "six").dropLastWhile { it.contains('i') } }") 

    println("> Retrieving Collection Parts:Chunked") // 一次元配列を多次元配列の取得
    println("(0..4).toList().chunked(3) = ${ (0..4).toList().chunked(3) }") 

    println("> Retrieving Collection Parts:Chunked:lambda function") // 一次元配列を多次元配列の取得:ラムダを実行
    println("(0..4).toList().chunked(3) { it.sum() } = ${ (0..4).toList().chunked(3) { it.sum() } }") // 各配列の合計値を計算

    println("> Retrieving Collection Parts:Windowed") // 一要素ずつスライドした多次元リストの取得
    println("(0..4).toList().windowed(3) = ${ (0..4).toList().windowed(3) }") 
    println("(0..4).toList().windowed(3, step = 2) = ${ (0..4).toList().windowed(3, step = 2) }") 
    println("(0..4).toList().windowed(3, partialWindows = true) = ${ (0..4).toList().windowed(3, partialWindows = true) }") 
    println("(0..4).toList().windowed(3, step = 2, partialWindows = true) = ${ (0..4).toList().windowed(3, step = 2, partialWindows = true) }") 

    println("> Retrieving Collection Parts:two-element windows") // 隣接する2要素をペアにしたリストの取得
    println("(0..4).toList().zipWithNext() = ${ (0..4).toList().zipWithNext() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").zipWithNext() = ${ listOf("one", "two", "three", "four", "five", "six").zipWithNext() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").zipWithNext { s1, s2 -> s1.length > s2.length } = ${ listOf("one", "two", "three", "four", "five", "six").zipWithNext { s1, s2 -> s1.length > s2.length } }") 

    println("> Retrieving Single Elements:Retrieving by position") // 単一の要素の取得
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAt(3) = ${ listOf("one", "two", "three", "four", "five", "six").elementAt(3) }") 
    println("sortedSetOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAt(0) = ${ sortedSetOf("one", "two", "three", "four", "five", "six").elementAt(0) }") 

    println("> Retrieving Single Elements:Retrieving by position:first and the last element") // 単一の要素の取得:先頭/末端の要素の取得
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").first() = ${ listOf("one", "two", "three", "four", "five", "six").first() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").last() = ${ listOf("one", "two", "three", "four", "five", "six").last() }") 

    println("> Retrieving Single Elements:Retrieving by position:non-existing positions") // 単一の要素の取得:存在しないケース
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAtOrNull(6) = ${ listOf("one", "two", "three", "four", "five", "six").elementAtOrNull(6) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAtOrElse(6) { index -> \"The value for index \$index is undefined\"} = ${ listOf("one", "two", "three", "four", "five", "six").elementAtOrElse(6) { index -> "The value for index $index is undefined" } }") 

    println("> Retrieving Single Elements:Retrieving by condition:first and the last element") // 単一の要素の取得:条件付き:先頭/末端の要素の取得
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").first { it.length > 3 }  = ${ listOf("one", "two", "three", "four", "five", "six").first { it.length > 3 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").last { it.startsWith(\"f\") } = ${ listOf("one", "two", "three", "four", "five", "six").last { it.startsWith("f") } }") 

    println("> Retrieving Single Elements:Retrieving by condition:first and the last element:non-existing:use aliases") // 単一の要素の取得:条件付き:先頭/末端の要素の取得:存在しないケース：使用推奨のエイリアス
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").find { it.length > 5 }  = ${ listOf("one", "two", "three", "four", "five", "six").find { it.length > 5 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").findLast { it.startsWith(\"V\") } = ${ listOf("one", "two", "three", "four", "five", "six").findLast { it.startsWith("V") } }") 

    println("> Retrieving Single Elements:Retrieving by condition:first and the last element:non-existing") // 単一の要素の取得:条件付き:先頭/末端の要素の取得:存在しないケース:非推奨
    println("[use find]    listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").firstOrNull { it.length > 5 }  = ${ listOf("one", "two", "three", "four", "five", "six").firstOrNull { it.length > 5 }  }") 
    println("[use findLst] listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").lastOrNull { it.startsWith(\"V\") } = ${ listOf("one", "two", "three", "four", "five", "six").lastOrNull { it.startsWith("V") } }") 

    println("> Retrieving Single Elements:Checking existence") // 単一の要素の取得:存在確認
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").contains(\"four\")  = ${ listOf("one", "two", "three", "four", "five", "six").contains("four") }") 
    println("\"one\" in listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\")  = ${ "one" in listOf("one", "two", "three", "four", "five", "six") }") 
    
    println("> Retrieving Single Elements:Checking existence:multiple") // 単一の要素の取得:存在確認:複数一致
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").containsAll(listOf(\"one\", \"four\"))  = ${ listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("one", "four")) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").containsAll(listOf(\"zero\", \"four\"))  = ${ listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("zero", "four")) }") 


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
// > isNotEmpty
// emptyList<String>().isNotEmpty() = false
// listOf(1, 2, 3, 4).isNotEmpty() = true
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
// > Retrieving Collection Parts:Slice
// listOf("one", "two", "three", "four", "five", "six").slice(1..3) = [two, three, four]
// listOf("one", "two", "three", "four", "five", "six").slice(0..4 step 2) = [one, three, five]
// listOf("one", "two", "three", "four", "five", "six").slice(setOf(3, 5, 0)) = [four, six, one]
// > Retrieving Collection Parts:Take
// listOf("one", "two", "three", "four", "five", "six").take(3) = [one, two, three]
// listOf("one", "two", "three", "four", "five", "six").takeLast(3) = [four, five, six]
// > Retrieving Collection Parts:Drop
// listOf("one", "two", "three", "four", "five", "six").drop(2) = [three, four, five, six]
// listOf("one", "two", "three", "four", "five", "six").dropLast(5) = [one]
// > Retrieving Collection Parts:TakeWhile
// listOf("one", "two", "three", "four", "five", "six").takeWhile { !it.startsWith('f') } = [one, two, three]
// listOf("one", "two", "three", "four", "five", "six").takeLastWhile { it != "three" } = [four, five, six]
// > Retrieving Collection Parts:DropWhile
// listOf("one", "two", "three", "four", "five", "six").dropWhile { it.length == 3 } = [three, four, five, six]
// listOf("one", "two", "three", "four", "five", "six").dropLastWhile { it.contains('i') } = [one, two, three, four]
// > Retrieving Collection Parts:Chunked
// (0..4).toList().chunked(3) = [[0, 1, 2], [3, 4]]
// > Retrieving Collection Parts:Chunked:lambda function
// (0..4).toList().chunked(3) { it.sum() } = [3, 7]
// > Retrieving Collection Parts:Windowed
// (0..4).toList().windowed(3) = [[0, 1, 2], [1, 2, 3], [2, 3, 4]]
// (0..4).toList().windowed(3, step = 2) = [[0, 1, 2], [2, 3, 4]]
// (0..4).toList().windowed(3, partialWindows = true) = [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4], [4]]
// (0..4).toList().windowed(3, step = 2, partialWindows = true) = [[0, 1, 2], [2, 3, 4], [4]]
// > Retrieving Collection Parts:two-element windows
// (0..4).toList().zipWithNext() = [(0, 1), (1, 2), (2, 3), (3, 4)]
// listOf("one", "two", "three", "four", "five", "six").zipWithNext() = [(one, two), (two, three), (three, four), (four, five), (five, six)]
// listOf("one", "two", "three", "four", "five", "six").zipWithNext { s1, s2 -> s1.length > s2.length } = [false, false, true, false, true]
// > Retrieving Single Elements:Retrieving by position
// listOf("one", "two", "three", "four", "five", "six").elementAt(3) = four
// sortedSetOf("one", "two", "three", "four", "five", "six").elementAt(0) = five
// > Retrieving Single Elements:Retrieving by position:first and the last element
// listOf("one", "two", "three", "four", "five", "six").first() = one
// listOf("one", "two", "three", "four", "five", "six").last() = six
// > Retrieving Single Elements:Retrieving by position:non-existing positions
// listOf("one", "two", "three", "four", "five", "six").elementAtOrNull(6) = null
// listOf("one", "two", "three", "four", "five", "six").elementAtOrElse(6) { index -> "The value for index $index is undefined"} = The value for index 6 is undefined
// > Retrieving Single Elements:Retrieving by condition:first and the last element
// listOf("one", "two", "three", "four", "five", "six").first { it.length > 3 }  = three
// listOf("one", "two", "three", "four", "five", "six").last { it.startsWith("f") } = five
// > Retrieving Single Elements:Retrieving by condition:first and the last element:non-existing:use aliases
// listOf("one", "two", "three", "four", "five", "six").find { it.length > 5 }  = null
// listOf("one", "two", "three", "four", "five", "six").findLast { it.startsWith("V") } = null
// > Retrieving Single Elements:Retrieving by condition:first and the last element:non-existing
// [use find]    listOf("one", "two", "three", "four", "five", "six").firstOrNull { it.length > 5 }  = null
// [use findLst] listOf("one", "two", "three", "four", "five", "six").lastOrNull { it.startsWith("V") } = null
// > Retrieving Single Elements:Checking existence
// listOf("one", "two", "three", "four", "five", "six").contains("four")  = true
// "one" in listOf("one", "two", "three", "four", "five", "six")  = true
// > Retrieving Single Elements:Checking existence:multiple
// listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("one", "four"))  = true
// listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("zero", "four"))  = false
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