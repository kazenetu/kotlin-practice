// SealedClass「Expr」の派生確認用クラス定義
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

// 実装例：色情報(参考:「Kotlinのsealed classを使いこなす」https://qiita.com/kikuchy/items/ad89a12029082be8d218)
sealed class Color {
    open class Rgb(val red: Int, val green: Int, val blue: Int): Color()
    {
        override fun toString(): String = "($red,$green,$blue)"
    }

    object Red:Rgb(255,0,0)
    object Green:Rgb(0,255,0)
    object Blue:Rgb(0,0,255)
}


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
    println("　")

    // 実装例：色情報(参考:「Kotlinのsealed classを使いこなす」https://qiita.com/kikuchy/items/ad89a12029082be8d218)
    println("---SealedClass : Example Color---")

    // 色単位で文字列を返す
    fun GetText(src: Color): String = 
        when(src) {
            is Color.Red -> "Red:$src"
            is Color.Green -> "Green:$src"
            is Color.Blue -> "Blue:$src"
            is Color.Rgb ->  "RGB:$src"
        }

    // 色情報付きの文字列を表示
    println("GetText(Color.Rgb(1,2,3)) = ${ GetText(Color.Rgb(1,2,3)) }")
    println("GetText(Color.Red) = ${ GetText(Color.Red) }")
    println("GetText(Color.RGreened) = ${ GetText(Color.Green) }")
    println("GetText(Color.Blue) = ${ GetText(Color.Blue) }")

}

// 出力：
// ---SealedClass : when expression---
// eval(Const(1.5)) = 1.5
// eval(Sum(Const(1.5), Const(0.5)) = 2.0
// eval(NotANumber) = NaN
// 　
// ---SealedClass : Example Color---
// GetText(Color.Rgb(1,2,3)) = RGB:(1,2,3)
// GetText(Color.Red) = Red:(255,0,0)
// GetText(Color.RGreened) = Green:(0,255,0)
// GetText(Color.Blue) = Blue:(0,0,255)