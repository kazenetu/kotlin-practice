import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/*
 * コルーチン：チャネル：終了と反復
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 *
 * チャネルを閉じて、これ以上要素が来ないことを示すことができる。
 * 受信側では、通常のforループを使用してチャネルから要素を受信すると便利。
 * クローズトークンが受信されるとすぐに反復が停止するため、
 * クローズの前に以前に送信されたすべての要素が受信されることが保証される。
 */
fun main() = runBlocking<Unit> {

    // チャネルの終了と反復
    println("---Closing and iteration over channels---")

    val channel = Channel<Int>()
    launch {
        for (x in 1..5) channel.send(x * x)
        channel.close() // 送信完了
    }

    // forループで送信対象を受信できる
    for (y in channel) println(y)
    println("Done!")
}

// 出力：
// ---Closing and iteration over channels---
// 1
// 4
// 9
// 16
// 25
// Done!