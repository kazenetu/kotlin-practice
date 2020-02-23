/*
 * オブジェクトを利用したユーティリティ
 */
object Utility {
    /*
     * カウント
     */
    private var count: Int = 0;

    /*
     * カウントアップ
     */
    fun countUp(): Int {
        return ++count;
    }  
}

/*
 * エントリポイント
 */
fun main() {
    // ユーティリティ呼び出し
    println("----Call Utility---")
    println(Utility.countUp())
    println(Utility.countUp())
    println(Utility.countUp())
}

// 出力：
// ----Call Utility---
// 1
// 2
// 3