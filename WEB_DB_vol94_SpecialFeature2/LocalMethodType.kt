/*
 * エントリポイント
 */
fun main() {

    /*
     * 関数リテラル
     */
     val getText: () -> String = 
        fun(): String {
            return "text!"
        }

    println(getText())
}

// 出力：text!