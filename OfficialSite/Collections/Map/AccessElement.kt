/*
 * コレクション：Map
 */
fun main() {

    // 各要素へのアクセス
    println("---Map : Retrieving keys and values---")
    println("> get element")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).get(\"key1\") = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).get("key1") }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3)[\"key1\"] = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3)["key1"] }")
    println("　")

    println("> not exists element")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3)[\"key4\"] = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3)["key4"] }")
    println("　")

    println("> getOrDefault")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).getOrDefault(\"key3\", -1) = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrDefault("key3", -1) }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).getOrDefault(\"key4\", -1) = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrDefault("key4", -1) }")
    println("　")

    println("> getOrElse")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).getOrElse(\"key3\", {-1}) = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrElse("key3", {-1}) }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).getOrElse(\"key4\", {-1}) = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrElse("key4", {-1}) }")
    println("　")

    println("> keys values")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).keys = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).keys }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3).values = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3).values }")

}

// 出力：
// ---Map : Retrieving keys and values---
// > get element
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).get("key1") = 1
// mapOf("key1" to 1, "key2" to 2, "key3" to 3)["key1"] = 1    
// 　
// > not exists element
// mapOf("key1" to 1, "key2" to 2, "key3" to 3)["key4"] = null
// 　
// > getOrDefault
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrDefault("key3", -1) = 3
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrDefault("key4", -1) = -1
// 　
// > getOrElse
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrElse("key3", {-1}) = 3
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).getOrElse("key4", {-1}) = -1
// 　
// > keys values
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).keys = [key1, key2, key3]
// mapOf("key1" to 1, "key2" to 2, "key3" to 3).values = [1, 2, 3]