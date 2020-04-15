/*
 * スーパークラス
 */
open class SuperClass(val age: Int) {
    open fun print() {
        println("SuperClass age=$age")
    }
}

/*
 * サブクラス:プライマリコンストラクタで継承
 * 　プライマリコンストラクタにパラメータ付きのスーパークラスを宣言
 */
class SubClassPrimary(age: Int): SuperClass(age) {
    override fun print() {
        println("SubClass age=$age")
    }
}

/*
 * サブクラス:セカンダリコンストラクタで継承
 * 　プライマリコンストラクタにパラメータなしのスーパークラスを宣言
 * 　セカンダリコンストラクタにパラメータ付きでsuperでスーパークラスのコンストラクタを宣言
 */
class SubClassSecondary: SuperClass {
    constructor(age: Int): super(age)

    override fun print() {
        println("SubClass age=$age")
    }
}


/*
 * エントリポイント
 */
fun main() {

    // スーパークラス
    println("----SuperClass---")
    val superClass = SuperClass(10)
    superClass.print()
    println("　")

    // サブクラス：プライマリコンストラクタの呼び出し
    println("----SubClass PrimaryConstructor---")
    val subClassPrimary = SubClassPrimary(20)
    subClassPrimary.print()
    println("　")

    // サブクラス：セカンダリコンストラクタの呼び出し
    println("----SubClass SecondaryConstructor---")
    val subClassSecondary = SubClassSecondary(30)
    subClassSecondary.print()
}

// 出力：
// ----SuperClass---
// SuperClass age=10
// 　
// ----SubClass PrimaryConstructor---
// SubClass age=20
// 　
// ----SubClass SecondaryConstructor---
// SubClass age=30