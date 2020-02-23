/*
 * コールバック用インターフェイス
 */
interface Callback {
    fun onCallbask(text: String)
}

/*
 * コールバック用インターフェイスをパラメータとするクラス
 */
class TestClass(val callback: Callback) {
    init {
        callback.onCallbask("Test")
    }
}

/*
 * エントリポイント
 */
fun main() {
    // テストクラスを呼び出し
    println("----Call TestClass---")
    TestClass(object:Callback {
        override fun onCallbask(text: String) {
            println("onCallbask is $text")
        }
    })
}

// 出力：
// ----Call TestClass---
// onCallbask is Test