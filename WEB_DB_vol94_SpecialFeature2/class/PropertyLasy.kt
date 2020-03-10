/*
 * デリゲートプロパティ実装例
 */
class LasyPropertyClass() {
    /*
     * lazyデリゲートプロパティ
     * ・どんな型も宣言可能。
     * ・valで宣言。
     * ・値の変更不可能。
     * ・初めて使用する際に初期化するため、エラーが発生しない。
     */
    val age: Int by lazy {
        print("computed! : ")
        10
    }
}

/*
 * エントリポイント
 */
fun main() {

    // デリゲートプロパティテスト
    println("----LasyPropertyClass---")
    val prop = LasyPropertyClass()
    println(prop.age)
    println(prop.age)
}

// 出力：
// ----LasyPropertyClass---
// computed! : 10
// 10