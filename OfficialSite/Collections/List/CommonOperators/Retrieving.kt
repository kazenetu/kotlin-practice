/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 基本的な操作
    println("---common Operators---")
    println("> Retrieving Collection Parts : Slice") // コレクションパーツの取得：要素インデックス指定の部分取り出し
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(1..3) = ${ listOf("one", "two", "three", "four", "five", "six").slice(1..3) }")                     // 範囲指定
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(0..4 step 2) = ${ listOf("one", "two", "three", "four", "five", "six").slice(0..4 step 2) }")       // 範囲指定：飛び番
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").slice(setOf(3, 5, 0)) = ${ listOf("one", "two", "three", "four", "five", "six").slice(setOf(3, 5, 0)) }") // 範囲指定：インデックス指定
    println("　")

    println("> Retrieving Collection Parts : Take") // コレクションパーツの取得：要素インデックス数指定で前後の部分取り出し
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").take(3) = ${ listOf("one", "two", "three", "four", "five", "six").take(3) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeLast(3) = ${ listOf("one", "two", "three", "four", "five", "six").takeLast(3) }") 
    println("　")

    println("> Retrieving Collection Parts : Drop") // コレクションパーツの取得：要素インデックス数指定で前後の要素の除外
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").drop(2) = ${ listOf("one", "two", "three", "four", "five", "six").drop(2) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropLast(5) = ${ listOf("one", "two", "three", "four", "five", "six").dropLast(5) }") 
    println("　")

    println("> Retrieving Collection Parts : TakeWhile") // コレクションパーツの取得：条件を満たすまでの要素の部分取り出し
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeWhile { !it.startsWith('f') } = ${ listOf("one", "two", "three", "four", "five", "six").takeWhile { !it.startsWith('f') } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").takeLastWhile { it != \"three\" } = ${ listOf("one", "two", "three", "four", "five", "six").takeLastWhile { it != "three" } }") 
    println("　")

    println("> Retrieving Collection Parts : DropWhile") // コレクションパーツの取得：条件を満たすまでの要素の除外
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropWhile { it.length == 3 } = ${ listOf("one", "two", "three", "four", "five", "six").dropWhile { it.length == 3 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").dropLastWhile { it.contains('i') } = ${ listOf("one", "two", "three", "four", "five", "six").dropLastWhile { it.contains('i') } }") 
    println("　")

    println("> Retrieving Collection Parts : Chunked") // 一次元配列を多次元配列の取得
    println("(0..4).toList().chunked(3) = ${ (0..4).toList().chunked(3) }") 
    println("　")

    println("> Retrieving Collection Parts : Chunked : lambda function") // 一次元配列を多次元配列の取得:ラムダを実行
    println("(0..4).toList().chunked(3) { it.sum() } = ${ (0..4).toList().chunked(3) { it.sum() } }") // 各配列の合計値を計算
    println("　")

    println("> Retrieving Collection Parts : Windowed") // 一要素ずつスライドした多次元リストの取得
    println("(0..4).toList().windowed(3) = ${ (0..4).toList().windowed(3) }") 
    println("(0..4).toList().windowed(3, step = 2) = ${ (0..4).toList().windowed(3, step = 2) }") 
    println("(0..4).toList().windowed(3, partialWindows = true) = ${ (0..4).toList().windowed(3, partialWindows = true) }") 
    println("(0..4).toList().windowed(3, step = 2, partialWindows = true) = ${ (0..4).toList().windowed(3, step = 2, partialWindows = true) }") 
    println("　")

    println("> Retrieving Collection Parts : two-element windows") // 隣接する2要素をペアにしたリストの取得
    println("(0..4).toList().zipWithNext() = ${ (0..4).toList().zipWithNext() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").zipWithNext() = ${ listOf("one", "two", "three", "four", "five", "six").zipWithNext() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").zipWithNext { s1, s2 -> s1.length > s2.length } = ${ listOf("one", "two", "three", "four", "five", "six").zipWithNext { s1, s2 -> s1.length > s2.length } }") 
    println("　")

    println("> Retrieving Single Elements : Retrieving by position") // 単一の要素の取得
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAt(3) = ${ listOf("one", "two", "three", "four", "five", "six").elementAt(3) }") 
    println("sortedSetOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAt(0) = ${ sortedSetOf("one", "two", "three", "four", "five", "six").elementAt(0) }") 
    println("　")

    println("> Retrieving Single Elements : Retrieving by position : first and the last element") // 単一の要素の取得:先頭/末端の要素の取得
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").first() = ${ listOf("one", "two", "three", "four", "five", "six").first() }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").last() = ${ listOf("one", "two", "three", "four", "five", "six").last() }") 
    println("　")

    println("> Retrieving Single Elements : Retrieving by position : non-existing positions") // 単一の要素の取得:存在しないケース
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAtOrNull(6) = ${ listOf("one", "two", "three", "four", "five", "six").elementAtOrNull(6) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").elementAtOrElse(6) { index -> \"The value for index \$index is undefined\"} = ${ listOf("one", "two", "three", "four", "five", "six").elementAtOrElse(6) { index -> "The value for index $index is undefined" } }") 
    println("　")

    println("> Retrieving Single Elements : Retrieving by condition : first and the last element") // 単一の要素の取得:条件付き:先頭/末端の要素の取得
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").first { it.length > 3 }  = ${ listOf("one", "two", "three", "four", "five", "six").first { it.length > 3 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").last { it.startsWith(\"f\") } = ${ listOf("one", "two", "three", "four", "five", "six").last { it.startsWith("f") } }") 
    println("　")

    println("> Retrieving Single Elements : Retrieving by condition : first and the last element : non-existing:use aliases") // 単一の要素の取得:条件付き:先頭/末端の要素の取得:存在しないケース：使用推奨のエイリアス
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").find { it.length > 5 }  = ${ listOf("one", "two", "three", "four", "five", "six").find { it.length > 5 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").findLast { it.startsWith(\"V\") } = ${ listOf("one", "two", "three", "four", "five", "six").findLast { it.startsWith("V") } }") 
    println("　")

    println("> Retrieving Single Elements : Retrieving by condition : first and the last element : non-existing") // 単一の要素の取得:条件付き:先頭/末端の要素の取得:存在しないケース:非推奨
    println("[use find]    listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").firstOrNull { it.length > 5 }  = ${ listOf("one", "two", "three", "four", "five", "six").firstOrNull { it.length > 5 }  }") 
    println("[use findLst] listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").lastOrNull { it.startsWith(\"V\") } = ${ listOf("one", "two", "three", "four", "five", "six").lastOrNull { it.startsWith("V") } }") 
    println("　")

    println("> Retrieving Single Elements : Checking existence") // 単一の要素の取得:存在確認
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").contains(\"four\")  = ${ listOf("one", "two", "three", "four", "five", "six").contains("four") }") 
    println("\"one\" in listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\")  = ${ "one" in listOf("one", "two", "three", "four", "five", "six") }") 
    println("　")
    
    println("> Retrieving Single Elements : Checking existence : multiple") // 単一の要素の取得:存在確認:複数一致
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").containsAll(listOf(\"one\", \"four\"))  = ${ listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("one", "four")) }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\", \"six\").containsAll(listOf(\"zero\", \"four\"))  = ${ listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("zero", "four")) }") 

}

// 出力：
// ---common Operators---
// > Retrieving Collection Parts : Slice
// listOf("one", "two", "three", "four", "five", "six").slice(1..3) = [two, three, four]
// listOf("one", "two", "three", "four", "five", "six").slice(0..4 step 2) = [one, three, five]
// listOf("one", "two", "three", "four", "five", "six").slice(setOf(3, 5, 0)) = [four, six, one]
// 　
// > Retrieving Collection Parts : Take
// listOf("one", "two", "three", "four", "five", "six").take(3) = [one, two, three]
// listOf("one", "two", "three", "four", "five", "six").takeLast(3) = [four, five, six]
// 　
// > Retrieving Collection Parts : Drop
// listOf("one", "two", "three", "four", "five", "six").drop(2) = [three, four, five, six]
// listOf("one", "two", "three", "four", "five", "six").dropLast(5) = [one]
// 　
// > Retrieving Collection Parts : TakeWhile
// listOf("one", "two", "three", "four", "five", "six").takeWhile { !it.startsWith('f') } = [one, two, three]
// listOf("one", "two", "three", "four", "five", "six").takeLastWhile { it != "three" } = [four, five, six]
// 　
// > Retrieving Collection Parts : DropWhile
// listOf("one", "two", "three", "four", "five", "six").dropWhile { it.length == 3 } = [three, four, five, six]
// listOf("one", "two", "three", "four", "five", "six").dropLastWhile { it.contains('i') } = [one, two, three, four]
// 　
// > Retrieving Collection Parts : Chunked
// (0..4).toList().chunked(3) = [[0, 1, 2], [3, 4]]
// 　
// > Retrieving Collection Parts : Chunked : lambda function
// (0..4).toList().chunked(3) { it.sum() } = [3, 7]
// 　
// > Retrieving Collection Parts : Windowed
// (0..4).toList().windowed(3) = [[0, 1, 2], [1, 2, 3], [2, 3, 4]]
// (0..4).toList().windowed(3, step = 2) = [[0, 1, 2], [2, 3, 4]]
// (0..4).toList().windowed(3, partialWindows = true) = [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4], [4]]
// (0..4).toList().windowed(3, step = 2, partialWindows = true) = [[0, 1, 2], [2, 3, 4], [4]]
// 　
// > Retrieving Collection Parts : two-element windows
// (0..4).toList().zipWithNext() = [(0, 1), (1, 2), (2, 3), (3, 4)]
// listOf("one", "two", "three", "four", "five", "six").zipWithNext() = [(one, two), (two, three), (three, four), (four, five), (five, six)]
// listOf("one", "two", "three", "four", "five", "six").zipWithNext { s1, s2 -> s1.length > s2.length } = [false, false, true, false, true]
// 　
// > Retrieving Single Elements : Retrieving by position
// listOf("one", "two", "three", "four", "five", "six").elementAt(3) = four
// sortedSetOf("one", "two", "three", "four", "five", "six").elementAt(0) = five
// 　
// > Retrieving Single Elements : Retrieving by position : first and the last element
// listOf("one", "two", "three", "four", "five", "six").first() = one
// listOf("one", "two", "three", "four", "five", "six").last() = six
// 　
// > Retrieving Single Elements : Retrieving by position : non-existing positions
// listOf("one", "two", "three", "four", "five", "six").elementAtOrNull(6) = null
// listOf("one", "two", "three", "four", "five", "six").elementAtOrElse(6) { index -> "The value for index $index is undefined"} = The value for index 6 is undefined
// 　
// > Retrieving Single Elements : Retrieving by condition : first and the last element
// listOf("one", "two", "three", "four", "five", "six").first { it.length > 3 }  = three
// listOf("one", "two", "three", "four", "five", "six").last { it.startsWith("f") } = five
// 　
// > Retrieving Single Elements : Retrieving by condition : first and the last element : non-existing:use aliases
// listOf("one", "two", "three", "four", "five", "six").find { it.length > 5 }  = null
// listOf("one", "two", "three", "four", "five", "six").findLast { it.startsWith("V") } = null
// 　
// > Retrieving Single Elements : Retrieving by condition : first and the last element : non-existing
// [use find]    listOf("one", "two", "three", "four", "five", "six").firstOrNull { it.length > 5 }  = null
// [use findLst] listOf("one", "two", "three", "four", "five", "six").lastOrNull { it.startsWith("V") } = null
// 　
// > Retrieving Single Elements : Checking existence
// listOf("one", "two", "three", "four", "five", "six").contains("four")  = true
// "one" in listOf("one", "two", "three", "four", "five", "six")  = true
// 　
// > Retrieving Single Elements : Checking existence : multiple
// listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("one", "four"))  = true
// listOf("one", "two", "three", "four", "five", "six").containsAll(listOf("zero", "four"))  = false
