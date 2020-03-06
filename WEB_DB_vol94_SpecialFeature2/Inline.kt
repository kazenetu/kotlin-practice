/*
 * ラムダ式：メソッド呼び出し
 * inlineキーワードで無名クラスを作らず、呼び出し元に展開される
 */
inline fun run(function:()->Unit){
    function()
}

//-------------------------
/*
 * ラムダ式：メソッド呼び出し：戻り値
 * inlineキーワードで無名クラスを作らず、呼び出し元に展開される
 */
inline fun calc(value: Int, op:(Int)->Int): Int{
    return op(value)
}

//-------------------------
/*
 * ジェネリックスのinline例
 * inlineキーワードで無名クラスを作らず、呼び出し元に展開される
 * reifiedキーワードで実際の型クラスとしてTが扱えるようになる
 */
inline fun <reified T> nameOf() = T::class.simpleName

//-------------------------
/*
 * エントリポイント
 */
fun main() {

    // ラムダ式のinlineの使用
    println("----inline run---")
    run({
        println("ABC")
        println("123")
    })

    // ラムダ式のinlineの使用
    println("----inline calc---")
    println("10+5=${ calc(10, {x -> x + 5}) }")
    println("10*5=${ calc(10, {it * 5}) }")

    // ジェネリックスのinlineの使用
    println("----inline generics nameOf<Int>---")
    println(nameOf<Int>())
}

// 出力：
// ----inline run---
// ABC
// 123
// ----inline calc---
// 10+5=15
// 10*5=50
// ----inline generics nameOf<Int>---
// Int