/*
 * コレクション：Map
 */
fun main() {

    // 追加と削除
    println("---Map :  plus and minus---")
    println("> plus")
    println("mapOf(\"key1\" to 1, \"key2\" to 2) + Pair(\"Key3\", 3) = ${ mapOf("key1" to 1, "key2" to 2)  + Pair("Key3", 3) }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2) + mapOf(\"Key3\" to 3, \"a\" to  10) = ${ mapOf("key1" to 1, "key2" to 2)  + mapOf("Key3" to 3, "a" to  10) }")
    println("　")

    println("> plus : update")
    println("mapOf(\"key1\" to 1, \"key2\" to 2) + Pair(\"key1\", 11) = ${ mapOf("key1" to 1, "key2" to 2)  + Pair("key1", 11) }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2) + mapOf(\"key1\" to 50, \"key3\" to  3) = ${ mapOf("key1" to 1, "key2" to 2)  + mapOf("key1" to 50, "key3" to  3) }")
    println("　")

    println("> minus")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3) - \"key2\" = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3) - "key2" }")
    println("mapOf(\"key1\" to 1, \"key2\" to 2, \"key3\" to 3) - listOf(\"key3\", \"key1\") = ${ mapOf("key1" to 1, "key2" to 2, "key3" to 3)  - listOf("key3", "key1") }")

}

// 出力：
// ---Map :  plus and minus---
// > plus
// mapOf("key1" to 1, "key2" to 2) + Pair("Key3", 3) = {key1=1, key2=2, Key3=3}
// mapOf("key1" to 1, "key2" to 2) + mapOf("Key3" to 3, "a" to  10) = {key1=1, key2=2, Key3=3, a=10}
// 　
// > plus : update
// mapOf("key1" to 1, "key2" to 2) + Pair("key1", 11) = {key1=11, key2=2}
// mapOf("key1" to 1, "key2" to 2) + mapOf("key1" to 50, "key3" to  3) = {key1=50, key2=2, key3=3}
// 　
// > minus
// mapOf("key1" to 1, "key2" to 2, "key3" to 3) - "key2" = {key1=1, key3=3}
// mapOf("key1" to 1, "key2" to 2, "key3" to 3) - listOf("key3", "key1") = {key2=2}