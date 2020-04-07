/*
 * コレクション：Map
 */
fun main() {

    // 初期化
    println("---Map : Initialize---")

    // 非常に短命なPairを生成するため、使用メモリ・パフォーマンスを求める場面では非推奨
    println("[use it only if performance isn't critical] mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3) = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3) }")

    // 過度のメモリ使用を回避する例：applyメソッド
    println("MutableList(10, {it}) = ${ mutableMapOf<String, Int>().apply { this["key1"] = 1; this["key2"] = 2; this["key3"] = 3 } }")

    // 文字列リストから「文字列とその長さ」のMapを作成する
    println("listOf(\"one\", \"two\", \"three\", \"four\").associateWith { it.length } ) = ${ listOf("one", "two", "three", "four").associateWith { it.length } }")

    // 空のMap
    println("emptyMap<String, Int>() = ${ emptyMap<String, Int>() }")

}

// 出力：
// ---Map : Initialize---
// [use it only if performance isn't critical] mapOf("key1" to 1, "key2" to 2, "key3" to 3) = {key1=1, key2=2, key3=3}
// MutableList(10, {it}) = {key1=1, key2=2, key3=3}
// listOf("one", "two", "three", "four").associateWith { it.length } ) = {one=3, two=3, three=5, four=4}
// emptyMap<String, Int>() = {}