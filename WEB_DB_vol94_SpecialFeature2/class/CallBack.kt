/*
 * コールバック用インターフェイス
 */
interface Callback {
    fun onCallbask(text: String)
}

/*
 * コールバック用インターフェイスをパラメータとするクラス
 * コールバック用プロパティを公開したバージョン
 */
class TestClassA(val callback: Callback) {
    init {
        callback.onCallbask("TestA")
    }
}

/*
 * コールバック用インターフェイスをパラメータとするクラス
 * コールバック用プロパティの非公開バージョン
 */
class TestClassB(private val callback: Callback) {
    init {
        callback.onCallbask("TestB")
    }
}

/*
 * エントリポイント
 */
fun main() {
    // テストクラスAを呼び出し
    println("----Call TestClassA---")
    val testA = TestClassA(object:Callback {
        override fun onCallbask(text: String) {
            println("onCallbask is $text")
        }
    })
    // TestClassAのプロパティのスコープがpublicのため、外部から呼び出し可能
    testA.callback.onCallbask("aaa")
    println("　")

    // テストクラスBを呼び出し
    println("----Call TestClassB---")
    val testB = TestClassB(object:Callback {
        override fun onCallbask(text: String) {
            println("onCallbask is $text")
        }
    })
    // TestClassAのプロパティのスコープがprivateのため、外部から呼び出し不可
    //testB.callback.onCallbask("aaa")
}

// 出力：
// ----Call TestClassA---
// onCallbask is TestA
// onCallbask is aaa
// 　
// ----Call TestClassB---
// onCallbask is TestB