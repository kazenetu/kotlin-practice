/*
 * null許容
 */
fun main() {
    // 文字列のnull許容
    var stringLocalField:String? = null
    println("stringLocalField:[$stringLocalField] length="+length(stringLocalField))

    // 文字列の変更
    stringLocalField="chenged stringLocalField"
    println("update stringLocalField:[$stringLocalField] length="+length(stringLocalField))

    // 数値のnull許容
    var intLocalField:Int? = null
    println("intLocalField:[$intLocalField]")

    // 数値の変更
    intLocalField = 100
    println("update intLocalField:[$intLocalField]")
}

/*
 * 文字列の長さを取得
 */
fun length(src: String?): Int {
    if(src == null){
        return 0
    }else{
        return src.count()
    }
}

// 出力：
// stringLocalField:[null] length=0
// update stringLocalField:[chenged stringLocalField] length=24
// intLocalField:[null]
// update intLocalField:[100]