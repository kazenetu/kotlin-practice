/*
 * ラムダ式：メソッド呼び出し
 */
fun run(function:()->Unit){
    function()
}

//-------------------------
/*
 * ラムダ式：メソッド呼び出し：戻り値
 */
fun calc(value: Int, op:(Int)->Int): Int{
    return op(value)
}

//-------------------------
/*
 * エントリポイント
 */
fun main() {

    // ラムダ式の利用
    println("----run---")
    run({
        println("ABC")
        println("123")
    })

    // ラムダ式の利用
    println("----calc---")
    println("10+5=${ calc(10, {x -> x + 5}) }")
    println("10*5=${ calc(10, {it * 5}) }")
}

// 出力：
// ----run---
// ABC
// 123
// ----calc---
// 10+5=15
// 10*5=50