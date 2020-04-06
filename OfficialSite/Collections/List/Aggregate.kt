/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 集計
    println("---ReadOnly List : Collection Aggregate---")
    println("listOf(6, 42, 10, 4).count() = ${ listOf(6, 42, 10, 4).count() }") 
    println("listOf(6, 42, 10, 4).average() = ${ listOf(6, 42, 10, 4).average() }") 
    println("　")

    println("> Collection Aggregate : max min")
    println("listOf(6, 42, 10, 4).max() = ${ listOf(6, 42, 10, 4).max() }") 
    println("listOf(6, 42, 10, 4).min() = ${ listOf(6, 42, 10, 4).min() }") 
    println("listOf(6, 42, 10, 4).minBy { it >= 10 } = ${ listOf(6, 42, 10, 4).minBy { it >= 10 } }") 
    println("listOf(\"one\", \"two\", \"three\", \"four\").maxWith(compareBy { it.length } ) = ${ listOf("one", "two", "three", "four").maxWith(compareBy { it.length } ) }") 
    println("　")

    println("> Collection Aggregate : sum")
    println("listOf(6, 42, 10, 4).sum()  = ${ listOf(6, 42, 10, 4).sum() }") 
    println("listOf(6, 42, 10, 4).sumBy { it * 2 } = ${ listOf(6, 42, 10, 4).sumBy { it * 2 } }")               // 戻り値はInt
    println("listOf(6, 42, 10, 4).sumByDouble { it / 2 } = ${ listOf(6, 42, 10, 4).sumByDouble { it.toDouble() / 2 } }")   // 戻り値はDouble
    println("　")

    println("> Collection Aggregate : Reduce and Fold") // 折り畳み(より具体的 連続処理)
    
    println("listOf(6, 42, 10, 4).reduce { sum, element -> sum + element }  = ${ listOf(6, 42, 10, 4).reduce { sum, element -> sum + element } }")                                  // reduceは初期値なし:最初の要素を初期値とする
    println("listOf(\"a\", \"b\", \"c\").reduce { buf, element -> buf + element.toUpperCase() } = ${ listOf("a", "b", "c").reduce { buf, element -> buf + element.toUpperCase() } }")            // 初期値(最初の要素)は大文字にならない
    println("listOf(\"a\", \"b\", \"c\").reduceRight { element, buf -> buf + element.toUpperCase() } = ${ listOf("a", "b", "c").reduceRight { element, buf -> buf + element.toUpperCase() } }")  // 初期値(最後の要素)は大文字にならない
    println("listOf(\"a\", \"b\", \"c\").reduceIndexed { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ listOf("a", "b", "c").reduceIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("listOf(\"a\", \"b\", \"c\").reduceRightIndexed { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ listOf("a", "b", "c").reduceRightIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("listOf(6, 42, 10, 4).reduceIndexed { index, sum, element -> if(index % 2 == 1) sum + element else sum } = ${ listOf(6, 42, 10, 4).reduceIndexed { index, sum, element -> if(index % 2 == 1) sum + element else sum } }")
    println("　")

    println("listOf(6, 42, 10, 4).fold(0) { sum, element -> sum + element } = ${ listOf(6, 42, 10, 4).fold(0) { sum, element -> sum + element } }")  // foldは初期値あり
    println("listOf(\"a\", \"b\", \"c\").fold(\"\") { buf, element -> buf + element.toUpperCase() } = ${ listOf("a", "b", "c").fold("") { buf, element -> buf + element.toUpperCase() } }")            // 初期値(最初の要素)も大文字になる
    println("listOf(\"a\", \"b\", \"c\").foldRight(\"\") { element, buf -> buf + element.toUpperCase() }  = ${ listOf("a", "b", "c").foldRight("") { element, buf -> buf + element.toUpperCase() } }")  // 初期値(最後の要素)も大文字になる
    println("listOf(\"a\", \"b\", \"c\").foldIndexed(\"\") { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ listOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("listOf(\"a\", \"b\", \"c\").foldRightIndexed(\"\") { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ listOf("a", "b", "c").foldRightIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("listOf(\"a\", \"b\", \"c\").foldIndexed(\"\") { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ listOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("listOf(6, 42, 10, 4).foldIndexed(0) { index, sum, element -> if(index % 2 == 1) sum + element else sum } = ${ listOf(6, 42, 10, 4).foldIndexed(0) { index, sum, element -> if(index % 2 == 1) sum + element else sum } }")

}

// 出力：
// ---ReadOnly List : Collection Aggregate---
// listOf(6, 42, 10, 4).count() = 4
// listOf(6, 42, 10, 4).average() = 15.5
// 　
// > Collection Aggregate : max min
// listOf(6, 42, 10, 4).max() = 42
// listOf(6, 42, 10, 4).min() = 4
// listOf(6, 42, 10, 4).minBy { it >= 10 } = 6
// listOf("one", "two", "three", "four").maxWith(compareBy { it.length } ) = three
// 　
// > Collection Aggregate : sum
// listOf(6, 42, 10, 4).sum()  = 62
// listOf(6, 42, 10, 4).sumBy { it * 2 } = 124
// listOf(6, 42, 10, 4).sumByDouble { it / 2 } = 31.0
// 　
// > Collection Aggregate : Reduce and Fold
// listOf(6, 42, 10, 4).reduce { sum, element -> sum + element }  = 62
// listOf("a", "b", "c").reduce { buf, element -> buf + element.toUpperCase() } = aBC
// listOf("a", "b", "c").reduceRight { element, buf -> buf + element.toUpperCase() } = cBA
// listOf("a", "b", "c").reduceIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" = a 1:B 2:C
// listOf("a", "b", "c").reduceRightIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" = a 0:B 1:C     
// listOf(6, 42, 10, 4).reduceIndexed { index, sum, element -> if(index % 2 == 1) sum + element else sum } = 52
// 　
// listOf(6, 42, 10, 4).fold(0) { sum, element -> sum + element } = 62
// listOf("a", "b", "c").fold("") { buf, element -> buf + element.toUpperCase() } = ABC
// listOf("a", "b", "c").foldRight("") { element, buf -> buf + element.toUpperCase() }  = CBA
// listOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" =  0:A 1:B 2:C     
// listOf("a", "b", "c").foldRightIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" = a 0:B 1:C 2:
// listOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" =  0:A 1:B 2:C     
// listOf(6, 42, 10, 4).foldIndexed(0) { index, sum, element -> if(index % 2 == 1) sum + element else sum } = 46