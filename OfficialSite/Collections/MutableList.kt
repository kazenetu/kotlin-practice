/*
 * バイナリサーチ用データクラス
 */
data class UserInfo(val name: String, val age: Int)

/*
 * 変換：平坦化用データクラス
 */
data class StringContainer(val values: List<String>)

/*
 * コレクション：MutableList
 */
fun main() {

    // 初期化
    println("---Mutable List:Initialize---")
    println("mutableListOf(1, 2, 3, 4) = ${mutableListOf(1, 2, 3, 4)}")
    println("MutableList(10, {it}) = ${ MutableList(10, {it}) }")
    println("MutableList(10){it} = ${ MutableList(10){it} }")
    println("(1..10).toMutableList() = ${ (1..10).toMutableList() }")
    println("mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)) = ${ mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)) }")

    // 基本的な操作
    println("---common Operators---")

    println("> plus and minus Operators")   //リストの追加と削除を生成
    println("(emptyList<String>() + \"ABC\").toMutableList() = ${ (emptyList<String>() + "ABC").toMutableList() }")
    println("mutableListOf(1, 2, 3, 4) - 1 = ${mutableListOf(1, 2, 3, 4) - 1}")

    println("> isEmpty") // リストの空チェック
    println("emptyList<String>().toMutableList().isEmpty() = ${ emptyList<String>().toMutableList().isEmpty() }")
    println("mutableListOf(1, 2, 3, 4).isEmpty() = ${mutableListOf(1, 2, 3, 4).isEmpty()}")

    println("> Transformations:Flattening") // 変換：平坦化
    println("mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)).flatten() = ${ mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)).flatten() }")
    val stringContainers = mutableListOf(
        StringContainer(mutableListOf("one", "two", "three")),
        StringContainer(mutableListOf("four", "five", "six")),
        StringContainer(mutableListOf("seven", "eight"))
    )
    println("stringContainers = $stringContainers")
    println("stringContainers.flatMap { it.values } = ${stringContainers.flatMap { it.values }}") // データクラスでの平坦化

    println("> Transformations:String representation") // 変換：コレクションの文字列化
    println("mutableListOf(\"one\", \"two\", \"three\").joinToString() = ${ mutableListOf("one", "two", "three").joinToString() }")
    println("mutableListOf(\"one\", \"two\", \"three\").joinToString(separator = \" | \", prefix = \"start: \", postfix = \": end\") = ${ mutableListOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\") = ${ mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>") }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString(limit = 3, truncated =\"<next...>\", separator = \" \") = ${ mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated = "<next...>", separator = " ") }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString { \"<\${it.toUpperCase()}>\" } = ${ mutableListOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").joinToString(transform = { \"<\${it.toUpperCase()}>\" }) = ${ mutableListOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) }")

    val stringBuffer = StringBuffer("The list of numbers: ") // バッファにコピー
    mutableListOf("one", "two", "three").joinTo(stringBuffer)
    println("mutableListOf(\"one\", \"two\", \"three\").joinTo(stringBuffer) = $stringBuffer")

    println("> Filtering:Filtering by predicate") // フィルタリング：基本
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").filter{ it.length > 3 } = ${ mutableListOf("one", "two", "three", "four").filter{ it.length > 3 } }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").filter({ it.length > 3 }) = ${ mutableListOf("one", "two", "three", "four").filter({ it.length > 3 }) }")

    println("> Filtering:Filtering by predicate:negative conditions") // フィルタリング：基本 否定条件
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").filterNot{ it.length > 3 } = ${ mutableListOf("one", "two", "three", "four").filterNot{ it.length > 3 } }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").filterNot({ it.length > 3 }) = ${ mutableListOf("one", "two", "three", "four").filterNot({ it.length > 3 }) }")

    println("> Filtering:Filtering by predicate:use element positions") // フィルタリング：基本 要素インデックス使用
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } = ${ mutableListOf("one", "two", "three", "four").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) = ${ mutableListOf("one", "two", "three", "four").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) }")

    println("> Filtering:Filtering by predicate:elements of a given type") // フィルタリング：基本 対象の型のみ
    println("mutableListOf(null, 1, \"two\", 3.0, \"four\").filterIsInstance<Int>() = ${ mutableListOf(null, 1, "two", 3.0, "four").filterIsInstance<Int>() }")
    println("mutableListOf(null, 1, \"two\", 3.0, \"four\").filterIsInstance<String>() = ${ mutableListOf(null, 1, "two", 3.0, "four").filterIsInstance<String>() }")

    println("> Filtering:Filtering by predicate:non-null elements") // フィルタリング：基本 null以外
    println("mutableListOf(null, 1, \"two\", 3.0, \"four\").filterNotNull() = ${ mutableListOf(null, 1, "two", 3.0, "four").filterNotNull() }")

    println("> Filtering:Partitioning") // フィルタリング：条件一致/不一致リスト取得
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").partition({ it.length > 3 }) = ${ mutableListOf("one", "two", "three", "four").partition({ it.length > 3 }) }")
    val (match, rest) = mutableListOf("one", "two", "three", "four").partition { it.length > 3 } // 一致と不一致の二つに分ける
    println("match = $match")
    println("rest = $rest")

    println("> Filtering:Testing predicates") // フィルタリング：条件一致の確認
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").any({ it.endsWith(\"e\") }) = ${ mutableListOf("one", "two", "three", "four").any({ it.endsWith("e") }) }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").none({ it.endsWith(\"e\") }) = ${ mutableListOf("one", "two", "three", "four").none({ it.endsWith("e") }) }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").all({ it.endsWith(\"e\") }) = ${ mutableListOf("one", "two", "three", "four").all({ it.endsWith("e") }) }")
    println("all[empty collection:true] emptyList<Int>().toMutableList().all { it > 5 } = ${ emptyList<Int>().all { it > 5 } }")

    println("> Filtering:Testing predicates:check the collection emptiness") // フィルタリング：コレクションの確認
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").any() = ${ mutableListOf("one", "two", "three", "four").any() }")
    println("emptyList<Int>().any() = ${ emptyList<Int>().toMutableList().any() }")
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").none() = ${ mutableListOf("one", "two", "three", "four").none() }")
    println("emptyList<Int>().none() = ${ emptyList<Int>().toMutableList().none() }")

    println("> Retrieving Collection Parts:Slice") // コレクションパーツの取得：要素インデックス指定の部分取り出し
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(1..3) = ${ mutableListOf("one", "two", "three", "four", "five", "six").slice(1..3) }")                     // 範囲指定
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(0..4 step 2) = ${ mutableListOf("one", "two", "three", "four", "five", "six").slice(0..4 step 2) }")       // 範囲指定：飛び番
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(setOf(3, 5, 0)) = ${ mutableListOf("one", "two", "three", "four", "five", "six").slice(setOf(3, 5, 0)) }") // 範囲指定：インデックス指定

    println("> Retrieving Collection Parts:Take") // コレクションパーツの取得：要素インデックス数指定で前後の部分取り出し
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").take(3) = ${ mutableListOf("one", "two", "three", "four", "five", "six").take(3) }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeLast(3) = ${ mutableListOf("one", "two", "three", "four", "five", "six").takeLast(3) }") 

    println("> Retrieving Collection Parts:Drop") // コレクションパーツの取得：要素インデックス数指定で前後の要素の除外
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").drop(2) = ${ mutableListOf("one", "two", "three", "four", "five", "six").drop(2) }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropLast(5) = ${ mutableListOf("one", "two", "three", "four", "five", "six").dropLast(5) }") 

    println("> Retrieving Collection Parts:TakeWhile") // コレクションパーツの取得：条件を満たすまでの要素の部分取り出し
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeWhile { !it.startsWith('f') } = ${ mutableListOf("one", "two", "three", "four", "five", "six").takeWhile { !it.startsWith('f') } }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeLastWhile { it != \"three\" } = ${ mutableListOf("one", "two", "three", "four", "five", "six").takeLastWhile { it != "three" } }") 

    println("> Retrieving Collection Parts:DropWhile") // コレクションパーツの取得：条件を満たすまでの要素の除外
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropWhile { it.length == 3 } = ${ mutableListOf("one", "two", "three", "four", "five", "six").dropWhile { it.length == 3 } }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropLastWhile { it.contains('i') } = ${ mutableListOf("one", "two", "three", "four", "five", "six").dropLastWhile { it.contains('i') } }") 

    println("> Retrieving Collection Parts:Chunked") // 一次元配列を多次元配列の取得
    println("(0..4).toMutableList().chunked(3) = ${ (0..4).toMutableList().chunked(3) }") 

    println("> Retrieving Collection Parts:Chunked:lambda function") // 一次元配列を多次元配列の取得:ラムダを実行
    println("(0..4).toMutableList().chunked(3) { it.sum() } = ${ (0..4).toMutableList().chunked(3) { it.sum() } }") // 各配列の合計値を計算

    println("> Retrieving Collection Parts:Windowed") // 一要素ずつスライドした多次元リストの取得
    println("(0..4).toMutableList().windowed(3) = ${ (0..4).toMutableList().windowed(3) }") 
    println("(0..4).toMutableList().windowed(3, step = 2) = ${ (0..4).toMutableList().windowed(3, step = 2) }") 
    println("(0..4).toMutableList().windowed(3, partialWindows = true) = ${ (0..4).toMutableList().windowed(3, partialWindows = true) }") 
    println("(0..4).toMutableList().windowed(3, step = 2, partialWindows = true) = ${ (0..4).toMutableList().windowed(3, step = 2, partialWindows = true) }") 

    println("> Retrieving Collection Parts:two-element windows") // 隣接する2要素をペアにしたリストの取得
    println("(0..4).toMutableList().zipWithNext() = ${ (0..4).toMutableList().zipWithNext() }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").zipWithNext() = ${ mutableListOf("one", "two", "three", "four", "five", "six").zipWithNext() }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").zipWithNext { s1, s2 -> s1.length > s2.length } = ${ mutableListOf("one", "two", "three", "four", "five", "six").zipWithNext { s1, s2 -> s1.length > s2.length } }") 


    // 更新系
    println("---Mutable List:write operations---")
    val writeList = mutableListOf(1, 2, 3)
    println("writeList = $writeList")

    println("> add")
    writeList.add(4)
    println("writeList.add(4) = $writeList")
    writeList.add(0, 5)  // パラメータが2つの場合は要素の挿入
    println("writeList.add(0, 5) = $writeList") 
    writeList.addAll(mutableListOf(15, 13, 12))
    println("writeList.addAll(mutableListOf(15, 13, 12)) = $writeList") 

    println("> update")
    writeList[0] = -1
    println("update \"writeList[0] = -1\" = $writeList") 

    println("> remove")
    writeList.removeAt(1)   // 指定した要素インデックスを削除する
    println("writeList.removeAt(1) = $writeList") 

    // ソート系
    println("---Mutable List:Sorting---")
    writeList.sort()
    println("writeList.sort() = $writeList") 
    writeList.sortDescending()
    println("writeList.sortDescending() = $writeList") 

    writeList.sortBy(){ it % 10 }
    println("writeList.sortBy(){ it % 10 } = $writeList") 
    writeList.sortByDescending(){ it % 10 }
    println("writeList.sortByDescending(){ it % 10 } = $writeList") 

    writeList.shuffle()
    println("writeList.shuffle() = $writeList") 
    writeList.reverse()
    println("writeList.reverse() = $writeList") 

    // 各要素へのアクセス
    println("---Mutable List:Access element---")
    val list = mutableListOf(1, 2, 3, 4)
    println("list = $list")

    println("> get element")
    println("list.get(0) = ${ list.get(0) }")
    println("list[0] = ${ list[0] }")
    println("list[0] = ${ list[0] }")

    println("> getOrNull")
    println("list.getOrNull(5) = ${ list.getOrNull(5) }")                 // getOrNull:要素インデックスが存在しない場合はnullを返す
    println("list.getOrNull(2) = ${ list.getOrNull(2) }")                 // getOrNull:要素インデックスが存在する場合は値を返す

    println("> getOrNull")
    println("list.getOrElse(2, {null}) = ${ list.getOrElse(2, {null}) }") // getOrElse:要素インデックスが存在する場合は値を返す
    println("list.getOrElse(5, {it}) = ${ list.getOrElse(5, {it}) }")     // getOrElse:要素インデックスが存在しない場合はit(5)を返す
    println("list.getOrElse(5, {null}) = ${ list.getOrElse(5, {null}) }") // getOrElse:要素インデックスが存在しない場合はnullを返す

    // リストの部分コピー(終了インデックス番号, 開始インデックス番号(含まない))
    println("---Mutable List:list parts---")
    println("mutableListOf(1, 2, 3, 4).subList(1, 3) = ${mutableListOf(1, 2, 3, 4).subList(1, 3)}")

    // 要素インデックスを取得
    println("---Mutable List:Linear search---")
    println("mutableListOf(1, 2, 3, 4, 1).indexOf(1) = ${mutableListOf(1, 2, 3, 4, 1).indexOf(1)}")
    println("mutableListOf(1, 2, 3, 4, 1).lastIndexOf(1) = ${mutableListOf(1, 2, 3, 4, 1).lastIndexOf(1)}")

    println("mutableListOf(1, 2, 3, 4, 1).indexOf(5) = ${mutableListOf(1, 2, 3, 4, 1).indexOf(5)}")           // 存在しない場合は-1
    println("mutableListOf(1, 2, 3, 4, 1).lastIndexOf(5) = ${mutableListOf(1, 2, 3, 4, 1).lastIndexOf(5)}")   // 存在しない場合は-1
    
    // 条件一致の要素インデックスを取得
    println("---Mutable List:Comparator binary search---")
    val users = mutableListOf(
        UserInfo("A",10),
        UserInfo("B",30),
        UserInfo("C",100)
    )
    println("users = $users")
    println("users.binarySearch(UserInfo(\"C\",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = ${ users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) }")

    // ソート済みのリストでバイナリサーチ
    println("---Mutable List:Binary search in sorted lists---")
    val binaryList = (1..20).toMutableList()
    binaryList.shuffle()    // 一旦バラバラにする
    println("binaryList.shuffle() = $binaryList")
    binaryList.sort()
    println("binaryList.sort() = $binaryList")
    println("binaryList.binarySearch(11) = ${ binaryList.binarySearch(11) }") // 要素インデックスを取得する

}

// 出力：
// ---Mutable List:Initialize---
// mutableListOf(1, 2, 3, 4) = [1, 2, 3, 4]
// MutableList(10, {it}) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// MutableList(10){it} = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// (1..10).toMutableList() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)) = [[1, 2, 3, 4], [10, 20, 30, 40]]
// ---common Operators---
// > plus and minus Operators
// (emptyList<String>() + "ABC").toMutableList() = [ABC]
// mutableListOf(1, 2, 3, 4) - 1 = [2, 3, 4]
// > isEmpty
// emptyList<String>().toMutableList().isEmpty() = true
// mutableListOf(1, 2, 3, 4).isEmpty() = false
// > Transformations:Flattening
// mutableListOf(mutableListOf(1, 2, 3, 4), mutableListOf(10, 20, 30, 40)).flatten() = [1, 2, 3, 4, 10, 20, 30, 40]
// stringContainers = [StringContainer(values=[one, two, three]), StringContainer(values=[four, five, six]), StringContainer(values=[seven, eight])]
// stringContainers.flatMap { it.values } = [one, two, three, four, five, six, seven, eight]
// > Transformations:String representation
// mutableListOf("one", "two", "three").joinToString() = one, two, three
// mutableListOf("one", "two", "three").joinToString(separator = " | ", prefix = "start: ", postfix = ": end") = start: one | two | three: end
// mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>") = one, two, three, <next...>
// mutableListOf("one", "two", "three", "four").joinToString(limit = 3, truncated ="<next...>", separator = " ") = one two three <next...>
// mutableListOf("one", "two", "three", "four").joinToString { "<${it.toUpperCase()}>" } = <ONE>, <TWO>, <THREE>, <FOUR>
// mutableListOf("one", "two", "three", "four").joinToString(transform = { "<${it.toUpperCase()}>" }) = <ONE>, <TWO>, <THREE>, <FOUR>
// mutableListOf("one", "two", "three").joinTo(stringBuffer) = The list of numbers: one, two, three
// > Filtering:Filtering by predicate
// mutableListOf("one", "two", "three", "four").filter{ it.length > 3 } = [three, four]
// mutableListOf("one", "two", "three", "four").filter({ it.length > 3 }) = [three, four]
// > Filtering:Filtering by predicate:negative conditions
// mutableListOf("one", "two", "three", "four").filterNot{ it.length > 3 } = [one, two]
// mutableListOf("one", "two", "three", "four").filterNot({ it.length > 3 }) = [one, two]
// > Filtering:Filtering by predicate:use element positions
// mutableListOf("one", "two", "three", "four").filterIndexed { index, s -> (index != 0) && (s.length <= 4) } = [two, four]
// mutableListOf("one", "two", "three", "four").filterIndexed({ index, s -> (index != 0) && (s.length <= 4) }) = [two, four]
// > Filtering:Filtering by predicate:elements of a given type
// mutableListOf(null, 1, "two", 3.0, "four").filterIsInstance<Int>() = [1]
// mutableListOf(null, 1, "two", 3.0, "four").filterIsInstance<String>() = [two, four]
// > Filtering:Filtering by predicate:non-null elements
// mutableListOf(null, 1, "two", 3.0, "four").filterNotNull() = [1, two, 3.0, four]
// > Filtering:Partitioning
// mutableListOf("one", "two", "three", "four").partition({ it.length > 3 }) = ([three, four], [one, two])
// match = [three, four]
// rest = [one, two]
// > Filtering:Testing predicates
// mutableListOf("one", "two", "three", "four").any({ it.endsWith("e") }) = true
// mutableListOf("one", "two", "three", "four").none({ it.endsWith("e") }) = false
// mutableListOf("one", "two", "three", "four").all({ it.endsWith("e") }) = false
// all[empty collection:true] emptyList<Int>().toMutableList().all { it > 5 } = true
// > Filtering:Testing predicates:check the collection emptiness
// mutableListOf("one", "two", "three", "four").any() = true
// emptyList<Int>().any() = false
// mutableListOf("one", "two", "three", "four").none() = false
// emptyList<Int>().none() = true
// > Retrieving Collection Parts:Slice
// mutableListOf("one", "two", "three", "four", "five", "six").slice(1..3) = [two, three, four]
// mutableListOf("one", "two", "three", "four", "five", "six").slice(0..4 step 2) = [one, three, five]
// mutableListOf("one", "two", "three", "four", "five", "six").slice(setOf(3, 5, 0)) = [four, six, one]
// > Retrieving Collection Parts:Take
// mutableListOf("one", "two", "three", "four", "five", "six").take(3) = [one, two, three]
// mutableListOf("one", "two", "three", "four", "five", "six").takeLast(3) = [four, five, six]
// > Retrieving Collection Parts:Drop
// mutableListOf("one", "two", "three", "four", "five", "six").drop(2) = [three, four, five, six]
// mutableListOf("one", "two", "three", "four", "five", "six").dropLast(5) = [one]
// > Retrieving Collection Parts:TakeWhile
// mutableListOf("one", "two", "three", "four", "five", "six").takeWhile { !it.startsWith('f') } = [one, two, three]
// mutableListOf("one", "two", "three", "four", "five", "six").takeLastWhile { it != "three" } = [four, five, six]
// > Retrieving Collection Parts:DropWhile
// mutableListOf("one", "two", "three", "four", "five", "six").dropWhile { it.length == 3 } = [three, four, five, six]
// mutableListOf("one", "two", "three", "four", "five", "six").dropLastWhile { it.contains('i') } = [one, two, three, four]
// > Retrieving Collection Parts:Chunked
// (0..4).toMutableList().chunked(3) = [[0, 1, 2], [3, 4]]
// > Retrieving Collection Parts:Chunked:lambda function
// (0..4).toMutableList().chunked(3) { it.sum() } = [3, 7]
// > Retrieving Collection Parts:Windowed
// (0..4).toMutableList().windowed(3) = [[0, 1, 2], [1, 2, 3], [2, 3, 4]]
// (0..4).toMutableList().windowed(3, step = 2) = [[0, 1, 2], [2, 3, 4]]
// (0..4).toMutableList().windowed(3, partialWindows = true) = [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4], [4]]
// (0..4).toMutableList().windowed(3, step = 2, partialWindows = true) = [[0, 1, 2], [2, 3, 4], [4]]
// > Retrieving Collection Parts:two-element windows
// (0..4).toMutableList().zipWithNext() = [(0, 1), (1, 2), (2, 3), (3, 4)]
// mutableListOf("one", "two", "three", "four", "five", "six").zipWithNext() = [(one, two), (two, three), (three, four), (four, five), (five, six)]
// mutableListOf("one", "two", "three", "four", "five", "six").zipWithNext { s1, s2 -> s1.length > s2.length } = [false, false, true, false, true]
// ---Mutable List:write operations---
// writeList = [1, 2, 3]
// > add
// writeList.add(4) = [1, 2, 3, 4]
// writeList.add(0, 5) = [5, 1, 2, 3, 4]
// writeList.addAll(mutableListOf(15, 13, 12)) = [5, 1, 2, 3, 4, 15, 13, 12]
// > update
// update "writeList[0] = -1" = [-1, 1, 2, 3, 4, 15, 13, 12]
// > remove
// writeList.removeAt(1) = [-1, 2, 3, 4, 15, 13, 12]
// ---Mutable List:Sorting---
// writeList.sort() = [-1, 2, 3, 4, 12, 13, 15]
// writeList.sortDescending() = [15, 13, 12, 4, 3, 2, -1]
// writeList.sortBy(){ it % 10 } = [-1, 12, 2, 13, 3, 4, 15]
// writeList.sortByDescending(){ it % 10 } = [15, 4, 13, 3, 12, 2, -1]
// writeList.shuffle() = [13, 4, 15, -1, 12, 3, 2]
// writeList.reverse() = [2, 3, 12, -1, 15, 4, 13]
// ---Mutable List:Access element---
// list = [1, 2, 3, 4]
// > get element
// list.get(0) = 1
// list[0] = 1
// list[0] = 1
// > getOrNull
// list.getOrNull(5) = null
// list.getOrNull(2) = 3
// > getOrNull
// list.getOrElse(2, {null}) = 3
// list.getOrElse(5, {it}) = 5
// list.getOrElse(5, {null}) = null
// ---Mutable List:list parts---
// mutableListOf(1, 2, 3, 4).subList(1, 3) = [2, 3]
// ---Mutable List:Linear search---
// mutableListOf(1, 2, 3, 4, 1).indexOf(1) = 0
// mutableListOf(1, 2, 3, 4, 1).lastIndexOf(1) = 4
// mutableListOf(1, 2, 3, 4, 1).indexOf(5) = -1
// mutableListOf(1, 2, 3, 4, 1).lastIndexOf(5) = -1
// ---Mutable List:Comparator binary search---
// users = [UserInfo(name=A, age=10), UserInfo(name=B, age=30), UserInfo(name=C, age=100)]
// users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = 2
// ---Mutable List:Binary search in sorted lists---
// binaryList.shuffle() = [17, 13, 16, 6, 10, 8, 11, 4, 5, 9, 3, 19, 1, 14, 7, 2, 18, 20, 15, 12]
// binaryList.sort() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
// binaryList.binarySearch(11) = 10