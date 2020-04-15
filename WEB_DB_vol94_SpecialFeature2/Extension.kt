/*
 * 拡張関数:大文字+スペース除去
 */
fun String.toUpperSpaceLess() = this.toUpperCase().replace(" ", "")

/*
 * 拡張関数:大文字+スペース除去(null許容)
 */
fun String?.toUpperSpaceLessNullable() = if(this == null) "null!!" else this?.toUpperCase().replace(" ", "")

/*
 * メソッド実行
 */
fun main() {
    // 大文字+スペース除去
    println("----String.toUpperSpaceLess----")
    println("Hello, world!!!".toUpperSpaceLess())
    println("　")

    // 大文字+スペース除去(null許容)
    println("----String.toUpperSpaceLess----")
    println("Hello, world!!!".toUpperSpaceLessNullable())
    val nullString: String? = null;
    println(nullString.toUpperSpaceLessNullable())
}

// 出力：
// ----String.toUpperSpaceLess----
// HELLO,WORLD!!!
// 　
// ----String.toUpperSpaceLess----
// HELLO,WORLD!!!
// null!!