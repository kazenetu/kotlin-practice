/*
 * インターフェイス
 */
interface Interface {
    
    /*
     * 抽象プロパティ
     */
    val age: Int
    
    /*
     * 抽象クラスのデフォルト実装
     */
    fun print() {
        println("default function age=$age")
    }
}

/*
 * クラスA
 */
class ClassA(override val age: Int): Interface {
    
    /*
     * 具象メソッド
     */
    override fun print() {
        println("ClassA age=$age")
    }
}

/*
 * クラスB
 */
class ClassB(override val age: Int): Interface {
    /*
     * 具象メソッド
     */
    override fun print() {
        println("ClassB age=$age")
    }
}

/*
 * クラスC
 * 具象メソッドなし
 */
class ClassC(override val age: Int): Interface

/*
 * エントリポイント
 */
fun main() {
    /*
     * ローカルメソッド：printメソッド呼び出し
     */
    fun callPrint(instance: Interface) {
        instance.print()
    }

    // クラスAの呼び出し
    println("----ClassA---")
    callPrint(ClassA(10))

    // クラスBの呼び出し
    println("----SubClassB---")
    callPrint(ClassB(20))

    // クラスCの呼び出し
    println("----SubClassC---")
    callPrint(ClassC(30))
}

// 出力：
// ----ClassA---
// ClassA age=10
// ----SubClassB---
// ClassB age=20
// ----SubClassC---
// default function age=30