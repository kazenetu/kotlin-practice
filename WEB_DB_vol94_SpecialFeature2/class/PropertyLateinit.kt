/*
 * 遅延初期化プロパティ確認用データクラス
 */
data class DataClass(var id: Int)

/*
 * 遅延初期化プロパティ実装例
 */
class LateinitPropertyClass() {
    /*
     * lateinitプロパティ
     * ・プリミティブ型は宣言できない。
     * ・varで宣言。
     * ・値の変更可能。
     * ・初期値を与えず変数を使用するとエラーが発生。
     * ・nullableは使用不可。
     */
    lateinit var dataClass: DataClass

    /*
     * 初期化メソッド
     */
    fun init() {
        dataClass = DataClass(10)
    }
}

/*
 * エントリポイント
 */
fun main() {

    // 遅延初期化プロパティテスト
    println("---- LateinitPropertyClass---")
    val prop = LateinitPropertyClass()
    prop.init()
    println(prop.dataClass.id)
    println("　")

    // 初期化しない状態でdataClass.id呼び出し
    println("---- LateinitPropertyClass:not initialize---")
    try {
        val notInit = LateinitPropertyClass()
        println(notInit.dataClass.id)
    } catch (e: Exception) {
        println(e)
    }

}

// 出力：
// ---- LateinitPropertyClass---
// 10
// 　
// ---- LateinitPropertyClass:not initialize---
// kotlin.UninitializedPropertyAccessException: lateinit property dataClass has not been initialized