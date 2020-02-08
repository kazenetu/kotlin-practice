/*
 * ローカルフィールド
 */
fun main() {
    // 文字列(再代入可能)
    var stringLocalField:String = "stringLocalField"
    var stringTypeInference = "stringtypeInference"
    println("stringLocalField:[$stringLocalField]")
    println("stringTypeInference:[$stringTypeInference]")

    // 文字列の変更
    stringLocalField="chenged stringLocalField"
    stringTypeInference = "chenged stringtypeInference"
    println("update stringLocalField:[$stringLocalField]")
    println("update stringTypeInference:[$stringTypeInference]")

    // 数値(再代入可能)
    var intLocalField:Int = 100
    var intTypeInference = 200
    println("intLocalField:[$intLocalField]")
    println("intTypeInference:[$intTypeInference]")

    // 数値の変更
    intLocalField++
    intTypeInference++
    println("update intLocalField:[$intLocalField]")
    println("update intTypeInference:[$intTypeInference]")

    //代入不可
    val valString = "ABC"
    val valInt = 1
    println("valString:[$valString]")
    println("valInt:[$valInt]")

}

// 出力：
// stringLocalField:[stringLocalField]
// stringTypeInference:[stringtypeInference]
// update stringLocalField:[chenged stringLocalField]
// update stringTypeInference:[chenged stringtypeInference]
// intLocalField:[100]
// intTypeInference:[200]
// update intLocalField:[101]
// update intTypeInference:[201]
// valString:[ABC]
// valInt:[1]
