/*
 * 抽象クラス
 */
abstract class AbstractClass(val age: Int) {
    /*
     * 抽象メソッド：protectedスコープ
     */
    abstract protected fun printMain()

    /*
     * エントリメソッド
     */
    fun print() {
        printMain()
    }
}

/*
 * サブクラスA
 */
class SubClassA(age: Int): AbstractClass(age) {
    /*
     * 具象メソッド：protectedスコープ
     */
    override fun printMain() {
        println("SubClassA age=$age")
    }
}

/*
 * サブクラスB
 */
class SubClassB(age: Int): AbstractClass(age) {
    /*
     * 具象メソッド：protectedスコープ
     */
    override fun printMain() {
        println("SubClassB age=$age")
    }
}

/*
 * エントリポイント
 */
fun main() {

    // 抽象クラスは生成できない
    println("----AbstractClass---")
    //val abstractClass = AbstractClass(10)
    //abstractClass.print()
    println("　")

    // サブクラスAの呼び出し
    println("----SubClassA---")
    val subClassA = SubClassA(20)
    subClassA.print()
    println("　")

    // サブクラスBの呼び出し
    println("----SubClassB---")
    val subClassB = SubClassB(20)
    subClassB.print()
}

// 出力：
// ----AbstractClass---
// 　
// ----SubClassA---
// SubClassA age=20
// 　
// ----SubClassB---
// SubClassB age=20