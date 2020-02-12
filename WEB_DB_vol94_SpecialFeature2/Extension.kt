/*
 * 拡張関数:大文字+スペース除去
 */
fun String.toUpperSpaceLess() = this.toUpperCase().replace(" ", "")

/*
 * メソッド実行
 */
fun main() {
    println("Hello, world!!!".toUpperSpaceLess())
}

// 出力：HELLO,WORLD!!!