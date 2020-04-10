/*
 * コレクション：Map
 */
fun main() {

    // フィルタリング
    println("---Map : Filtering---")
    println("> basic")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3, \"key12\" to 10).filter { (key, value) -> key.endsWith(\"2\") && value >= 10 } = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key12" to 10).filter { (key, value) -> key.endsWith("2") && value >= 10 } }")
    println("　")

    println("> filterKeys filterValues")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3, \"key12\" to 10).filterKeys { it.endsWith(\"2\") } = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key12" to 10).filterKeys { it.endsWith("2") } }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3, \"key12\" to 10).filterValues { it.value >= 10 } = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key12" to 10).filterValues { it >= 10 } }")
    println("　")

}

// 出力：
// ---Map : Filtering---
// > basic
// mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key12" to 10).filter { (key, value) -> key.endsWith("2") && value >= 10 } = {key12=10}
// 　
// > filterKeys filterValues
// mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key12" to 10).filterKeys { it.endsWith("2") } = {key2=2, key12=10}
// mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key12" to 10).filterValues { it.value >= 10 } = {key12=10}