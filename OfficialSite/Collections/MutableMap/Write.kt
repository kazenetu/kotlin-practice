/*
 * コレクション：MutableMap
 */
fun main() {

    // 更新系
    println("---Mutable Map : write operations---")
    val writeMap = mutableMapOf("one" to 1, "two" to 2)
    println("writeMap = $writeMap")
    println("　")

    println("> adding : put")
    writeMap.put("three", 3)
    println("writeMap.put(\"three\", 3) = $writeMap")

    writeMap.put("three", 30)
    println("writeMap.put(\"three\", 30) = $writeMap")

    println("> adding : putAll (adding)")
    writeMap.putAll(setOf("four" to 4, "five" to 5))
    println("writeMap.putAll(setOf(\"four\" to 4, \"five\" to 5)) = $writeMap")

    println("> adding : plusAssign")
    writeMap["six"] = 6
    println("\"writeMap[\"six\"] = 6\" = $writeMap") 

    writeMap += mapOf("seven" to 7, "eight" to 8)
    println("\"writeMap += mapOf(\"seven\" to 7, \"eight\" to 8)\" = $writeMap") 
    println("　")

    println("> removing : remove")
    writeMap.remove("one")
    println("writeMap.remove(\"one\") = $writeMap") 

    writeMap.remove("three", 3)
    println("[not exists] writeMap.remove(\"three\", 3) = $writeMap") 
    println("　")

    println("> removing : remove : keys values") // キーまたは値の配列から削除
    writeMap.keys.remove("three")
    println("writeMap.keys.remove(\"three\") = $writeMap") 

    writeMap.values.remove(8)
    println("writeMap.values.remove(8) = $writeMap") 
    println("　")

    println("> removing : minusAssign")
    writeMap -= "seven"
    println("writeMap -= \"seven\" = $writeMap") 
    writeMap -= "nine"
    println("[not exists] writeMap -= \"nine\" = $writeMap") 

}

// 出力：
// ---Mutable Map : write operations---
// writeMap = {one=1, two=2}
// 　
// > adding : put
// writeMap.put("three", 3) = {one=1, two=2, three=3}
// writeMap.put("three", 30) = {one=1, two=2, three=30}
// > adding : putAll (adding)
// writeMap.putAll(setOf("four" to 4, "five" to 5)) = {one=1, two=2, three=30, four=4, five=5}
// > adding : plusAssign
// "writeMap["six"] = 6" = {one=1, two=2, three=30, four=4, five=5, six=6}
// "writeMap += mapOf("seven" to 7, "eight" to 8)" = {one=1, two=2, three=30, four=4, five=5, six=6, seven=7, eight=8}
// 　
// > removing : remove
// writeMap.remove("one") = {two=2, three=30, four=4, five=5, six=6, seven=7, eight=8}
// [not exists] writeMap.remove("three", 3) = {two=2, three=30, four=4, five=5, six=6, seven=7, eight=8}
// 　
// > removing : remove : keys values
// writeMap.keys.remove("three") = {two=2, four=4, five=5, six=6, seven=7, eight=8}
// writeMap.values.remove(8) = {two=2, four=4, five=5, six=6, seven=7}
// 　
// > removing : minusAssign
// writeMap -= "seven" = {two=2, four=4, five=5, six=6}
// [not exists] writeMap -= "nine" = {two=2, four=4, five=5, six=6}