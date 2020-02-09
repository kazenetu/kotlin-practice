/*
 * null許容
 */
fun main() {
    // 文字列のnull許容
    var stringLocalField:String? = null
    println("stringLocalField:[$stringLocalField]")

    // 文字列の変更
    stringLocalField="chenged stringLocalField"
    println("update stringLocalField:[$stringLocalField]")

    // 数値のnull許容
    var intLocalField:Int? = null
    println("intLocalField:[$intLocalField]")

    // 数値の変更
    intLocalField = 100
    println("update intLocalField:[$intLocalField]")
}

// 出力：
// stringLocalField:[null]
// update stringLocalField:[chenged stringLocalField]
// intLocalField:[null]
// update intLocalField:[100]