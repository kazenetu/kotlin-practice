/*
 * ラムダ式
 */
fun run(function:()->Unit){
    function()
}


/*
 * エントリポイント
 */
fun main() {

    /*
     * ラムダ式の利用
     */
    run({
        println("ABC")
        println("123")
    })
}

// 出力：
// ABC
// 123