/*
 * コレクション：Map
 */
fun main() {

    // グルーピング
    println("---Map : Grouping---")
    println("> groupBy")
    // 要素を直接変換
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupBy { it.first().toUpperCase() } = ${ listOf("one", "two", "three", "four", "five").groupBy { it.first().toUpperCase() } }")
    // 要素の値を抽出したものを使用して変換
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }) = ${ listOf("one", "two", "three", "four", "five").groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }) }")
    println("　")

    println("> groupingBy") // グルーピングした各要素のカウントを行う※groupByではなくgroupingBy
    println("listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupingBy { it.first().toUpperCase() }.eachCount() = ${ listOf("one", "two", "three", "four", "five").groupingBy { it.first().toUpperCase() }.eachCount() }")
    println("　")

    println("> groupingBy : fold") // 「頭文字とmutableList」のPairのコレクションを取得する
    val initialNumbers = listOf("one", "two", "three", "four", "five").groupingBy { it.first() }
    println("\"val initialNumbers = listOf(\"one\", \"two\", \"three\", \"four\", \"five\").groupingBy { it.first() }\" = ${ initialNumbers.eachCount() } [eachCount]")
    println("　")

    println("> groupingBy : fold : get [initial to List] Map") // 「頭文字と対象要素のList」のMapを取得する
    println("initialNumbers.fold(listOf<String>()) { accumulator, element -> accumulator + element } = ${ initialNumbers.fold(listOf<String>()) { accumulator, element -> accumulator + element } }")
    println("initialNumbers.fold(emptyList<String>()) { accumulator, element -> accumulator + element } = ${ initialNumbers.fold(emptyList<String>()) { accumulator, element -> accumulator + element } }")
    println("　")

    println("> groupingBy : fold : get [initial , List] Pair Collection") // 「頭文字とmutableList」のPairのコレクションを取得する
    // 頭文字単位で「頭文字とmutableList」のPairを生成
    // すべての要素(element)にaccumulator(「頭文字とmutableList」)のリストを追加
    // リストに要素が格納されたMapを返す
    val initialNumbersMap = initialNumbers
         .fold({ key, _ -> key to mutableListOf<String>() },
          { _, accumulator, element ->
              accumulator.also { (_, list) -> list.add(element) }
          })
    println(""""val initialNumbersMap = initialNumbers
         .fold({ key, _ -> key to mutableListOf<String>() },
          { _, accumulator, element ->
              accumulator.also { (_, list) -> list.add(element) }
          })" 
          = $initialNumbersMap""")

    println("initialNumbersMap.values = ${ initialNumbersMap.values }") // valuesで頭文字と対象要素のPairのコレクションを取得
    println("　")

    println("> groupingBy : reduce") //「頭文字と対象要素を連結した文字列」のMapを取得する
    println("initialNumbers.reduce { _, accumulator, element -> accumulator  + \":\$element\" } = ${ initialNumbers.reduce { _, accumulator, element -> accumulator + ":$element" } }")
    println("　")

    println("> groupingBy : aggregate") //「頭文字と対象要素を連結した文字列」のMapを取得する
    val aggregated = initialNumbers
        .aggregate { key, accumulator: StringBuilder?, element, first -> 
            if (first) // first element
                StringBuilder().append(element)
            else
                accumulator!!.append(",").append(element)
        }
    println(""""val aggregated = initialNumbers
        .aggregate { key, accumulator: StringBuilder?, element, first -> 
            if (first) // first element
                StringBuilder().append(element)
            else
                accumulator!!.append(\",\").append(element)
        }" 
        = $aggregated""")

}

// 出力：
// ---Map : Grouping---
// > groupBy
// listOf("one", "two", "three", "four", "five").groupBy { it.first().toUpperCase() } = {O=[one], T=[two, three], F=[four, five]}
// listOf("one", "two", "three", "four", "five").groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }) = {o=[ONE], t=[TWO, THREE], f=[FOUR, FIVE]}
// 　
// > groupingBy
// listOf("one", "two", "three", "four", "five").groupingBy { it.first().toUpperCase() }.eachCount() = {O=1, T=2, F=2}
// 　
// > groupingBy : fold
// "val initialNumbers = listOf("one", "two", "three", "four", "five").groupingBy { it.first() }" = {o=1, t=2, f=2} [eachCount]
// 　
// > groupingBy : fold : get [initial to List] Map
// initialNumbers.fold(listOf<String>()) { accumulator, element -> accumulator + element } = {o=[one], t=[two, three], f=[four, five]}
// initialNumbers.fold(emptyList<String>()) { accumulator, element -> accumulator + element } = {o=[one], t=[two, three], f=[four, five]}
// 　
// > groupingBy : fold : get [initial , List] Pair Collection
// "val initialNumbersMap = initialNumbers
//          .fold({ key, _ -> key to mutableListOf<String>() },
//           { _, accumulator, element ->
//               accumulator.also { (_, list) -> list.add(element) }
//           })"
//           = {o=(o, [one]), t=(t, [two, three]), f=(f, [four, five])}
// initialNumbersMap.values = [(o, [one]), (t, [two, three]), (f, [four, five])]
// 　
// > groupingBy : reduce
// initialNumbers.reduce { _, accumulator, element -> accumulator  + ":$element" } = {o=one, t=two:three, f=four:five}
// 　
// > groupingBy : aggregate
// "val aggregated = initialNumbers
//         .aggregate { key, accumulator: StringBuilder?, element, first ->
//             if (first) // first element
//                 StringBuilder().append(element)
//             else
//                 accumulator!!.append(\",\").append(element)
//         }"
//         = {o=one, t=two,three, f=four,five}