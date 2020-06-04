import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start

    // 無限に繰り返す
    while (true) send(x++)
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numbers) if (x % prime != 0) send(x)
}

/*
 * コルーチン：チャネル：パイプライン
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 *
 * チャネルはつなげることができる。
 */
fun main() = runBlocking<Unit> {

    // パイプライン
    println("---Pipelines---")

    // 無限にインクリメントした値を返すチャネル
    val numbers = numbersFrom(1)

    // 無限にインクリメントするチャネルをパラメータにそれを二乗するチャネル
    val squares = square(numbers)

    // 5回受信し、表示する
    repeat(5) {
        println(squares.receive())
    }

    // 子コルーチンをキャンセルする
    coroutineContext.cancelChildren()

    println("Done!")
    println("　")

    // パイプライン:フィルター
    println("---Pipelines: filter---")

    // 素数を表示
    var cur = numbersFrom(2)
    repeat(10) {
        val prime = cur.receive()
        println(prime)

        // 次回以降は無限にインクリメントするチャネルをパラメータにしたfilterを呼び出す
        cur = filter(cur, prime)
    }

    // 子コルーチンをキャンセルする
    coroutineContext.cancelChildren()

    println("Done!")
}

// 出力：
// ---Building channel producers---
// 1
// 4
// 9
// 16
// 25
// Done!
// 　
// ---Pipelines: filter---
// 2
// 3
// 5
// 7
// 11
// 13
// 17
// 19
// 23
// 29
// Done!