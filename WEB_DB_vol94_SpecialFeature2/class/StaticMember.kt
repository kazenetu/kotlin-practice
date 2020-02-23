/*
 * スタティックメンバありクラス
 */
class StaticMember {
    /*
     * クラスメンバの定義
     */
    companion object {
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
}

/*
 * エントリポイント
 */
fun main() {
    // ユーティリティ呼び出し
    println("----Call StaticMember---")
    println(StaticMember.countUp())
    println(StaticMember.countUp())
    println(StaticMember.countUp())
}

// 出力：
// ----Call StaticMember---
// 1
// 2
// 3