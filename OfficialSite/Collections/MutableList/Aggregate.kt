/*
 * コレクション：MutableList
 */
fun main() {

    // 集計
    println("---ReadOnly List : Collection Aggregate---")
    println("mutableListOf(6, 42, 10, 4).count() = ${ mutableListOf(6, 42, 10, 4).count() }") 
    println("mutableListOf(6, 42, 10, 4).average() = ${ mutableListOf(6, 42, 10, 4).average() }") 
    println("　")

    println("> Collection Aggregate : max min")
    println("mutableListOf(6, 42, 10, 4).max() = ${ mutableListOf(6, 42, 10, 4).max() }") 
    println("mutableListOf(6, 42, 10, 4).min() = ${ mutableListOf(6, 42, 10, 4).min() }") 
    println("mutableListOf(6, 42, 10, 4).minBy { it >= 10 } = ${ mutableListOf(6, 42, 10, 4).minBy { it >= 10 } }") 
    println("mutableListOf(\"one\", \"two\", \"three\", \"four\").maxWith(compareBy { it.length } ) = ${ mutableListOf("one", "two", "three", "four").maxWith(compareBy { it.length } ) }") 
    println("　")

    println("> Collection Aggregate : sum")
    println("mutableListOf(6, 42, 10, 4).sum()  = ${ mutableListOf(6, 42, 10, 4).sum() }") 
    println("mutableListOf(6, 42, 10, 4).sumBy { it * 2 } = ${ mutableListOf(6, 42, 10, 4).sumBy { it * 2 } }")               // 戻り値はInt
    println("mutableListOf(6, 42, 10, 4).sumByDouble { it / 2 } = ${ mutableListOf(6, 42, 10, 4).sumByDouble { it.toDouble() / 2 } }")   // 戻り値はDouble
    println("　")

    println("> Collection Aggregate : Reduce and Fold") // 折り畳み(より具体的 連続処理)
    
    println("mutableListOf(6, 42, 10, 4).reduce { sum, element -> sum + element }  = ${ mutableListOf(6, 42, 10, 4).reduce { sum, element -> sum + element } }")                                  // reduceは初期値なし:最初の要素を初期値とする
    println("mutableListOf(\"a\", \"b\", \"c\").reduce { buf, element -> buf + element.toUpperCase() } = ${ mutableListOf("a", "b", "c").reduce { buf, element -> buf + element.toUpperCase() } }")            // 初期値(最初の要素)は大文字にならない
    println("mutableListOf(\"a\", \"b\", \"c\").reduceRight { element, buf -> buf + element.toUpperCase() } = ${ mutableListOf("a", "b", "c").reduceRight { element, buf -> buf + element.toUpperCase() } }")  // 初期値(最後の要素)は大文字にならない
    println("mutableListOf(\"a\", \"b\", \"c\").reduceIndexed { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ mutableListOf("a", "b", "c").reduceIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("mutableListOf(\"a\", \"b\", \"c\").reduceRightIndexed { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ mutableListOf("a", "b", "c").reduceRightIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("mutableListOf(6, 42, 10, 4).reduceIndexed { index, sum, element -> if(index % 2 == 1) sum + element else sum } = ${ mutableListOf(6, 42, 10, 4).reduceIndexed { index, sum, element -> if(index % 2 == 1) sum + element else sum } }")
    println("　")

    println("mutableListOf(6, 42, 10, 4).fold(0) { sum, element -> sum + element } = ${ mutableListOf(6, 42, 10, 4).fold(0) { sum, element -> sum + element } }")  // foldは初期値あり
    println("mutableListOf(\"a\", \"b\", \"c\").fold(\"\") { buf, element -> buf + element.toUpperCase() } = ${ mutableListOf("a", "b", "c").fold("") { buf, element -> buf + element.toUpperCase() } }")            // 初期値(最初の要素)も大文字になる
    println("mutableListOf(\"a\", \"b\", \"c\").foldRight(\"\") { element, buf -> buf + element.toUpperCase() }  = ${ mutableListOf("a", "b", "c").foldRight("") { element, buf -> buf + element.toUpperCase() } }")  // 初期値(最後の要素)も大文字になる
    println("limutableListOfstOf(\"a\", \"b\", \"c\").foldIndexed(\"\") { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ mutableListOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("mutableListOf(\"a\", \"b\", \"c\").foldRightIndexed(\"\") { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ mutableListOf("a", "b", "c").foldRightIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("mutableListOf(\"a\", \"b\", \"c\").foldIndexed(\"\") { index, buf, element -> buf + \" \$index:\${ element.toUpperCase() }\" = ${ mutableListOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" } }")
    println("mutableListOf(6, 42, 10, 4).foldIndexed(0) { index, sum, element -> if(index % 2 == 1) sum + element else sum } = ${ mutableListOf(6, 42, 10, 4).foldIndexed(0) { index, sum, element -> if(index % 2 == 1) sum + element else sum } }")

}

// 出力：
// ---ReadOnly List : Collection Aggregate---
// mutableListOf(6, 42, 10, 4).count() = 4
// mutableListOf(6, 42, 10, 4).average() = 15.5
// 　
// > Collection Aggregate : max min
// mutableListOf(6, 42, 10, 4).max() = 42
// mutableListOf(6, 42, 10, 4).min() = 4
// mutableListOf(6, 42, 10, 4).minBy { it >= 10 } = 6
// mutableListOf("one", "two", "three", "four").maxWith(compareBy { it.length } ) = three
// 　
// > Collection Aggregate : sum
// mutableListOf(6, 42, 10, 4).sum()  = 62
// mutableListOf(6, 42, 10, 4).sumBy { it * 2 } = 124
// mutableListOf(6, 42, 10, 4).sumByDouble { it / 2 } = 31.0
// 　
// > Collection Aggregate : Reduce and Fold
// mutableListOf(6, 42, 10, 4).reduce { sum, element -> sum + element }  = 62
// mutableListOf("a", "b", "c").reduce { buf, element -> buf + element.toUpperCase() } = aBC
// mutableListOf("a", "b", "c").reduceRight { element, buf -> buf + element.toUpperCase() } = cBA
// mutableListOf("a", "b", "c").reduceIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" = a 1:B 2:C
// mutableListOf("a", "b", "c").reduceRightIndexed { index, buf, element -> buf + " $index:${ element.toUpperCase() }" = a 0:B 1:C
// mutableListOf(6, 42, 10, 4).reduceIndexed { index, sum, element -> if(index % 2 == 1) sum + element else sum } = 52
// 　
// mutableListOf(6, 42, 10, 4).fold(0) { sum, element -> sum + element } = 62
// mutableListOf("a", "b", "c").fold("") { buf, element -> buf + element.toUpperCase() } = ABC
// mutableListOf("a", "b", "c").foldRight("") { element, buf -> buf + element.toUpperCase() }  = CBA
// limutableListOfstOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" =  0:A 1:B 2:C
// mutableListOf("a", "b", "c").foldRightIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" = a 0:B 1:C 2:
// mutableListOf("a", "b", "c").foldIndexed("") { index, buf, element -> buf + " $index:${ element.toUpperCase() }" =  0:A 1:B 2:C
// mutableListOf(6, 42, 10, 4).foldIndexed(0) { index, sum, element -> if(index % 2 == 1) sum + element else sum } = 46