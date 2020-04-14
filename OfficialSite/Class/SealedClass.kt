// SealedClass「Expr」の派生確認用クラス定義
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

/*
 * SealedClass
 * 同一ファイル内のみで有効な抽象クラス
 */
fun main() {

    // SealedClass「Expr」の派生確認
    println("---SealedClass : when expression---")

    // 派生毎の処理を行うメソッド
    fun eval(expr: Expr): Double = when(expr) {
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NotANumber -> Double.NaN
    }

    // 派生クラスの動作確認
    println("eval(Const(1.5)) = ${ eval(Const(1.5)) }")
    println("eval(Sum(Const(1.5), Const(0.5)) = ${ eval(Sum(Const(1.5), Const(0.5))) }")
    println("eval(NotANumber) = ${ eval(NotANumber) }")

}

// 出力：
// ---SealedClass : when expression---
// eval(Const(1.5)) = 1.5
// eval(Sum(Const(1.5), Const(0.5)) = 2.0
// eval(NotANumber) = NaN