import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/*
 * コルーチン：チャネル：バッファリングされたチャネル
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 *
 * 今までのサンプルはバッファリングされていないチャネルである。
 * 送信者と受信者が互いに出会ったときにエレメントを転送される（ランデブーとも呼ばれる）。
 * 送信が最初に呼び出された場合は、受信が呼び出されるまで中断され、
 * 受信が最初に呼び出された場合は、送信が呼び出されるまで中断される。
 * 
 * Channelファクトリー関数とプロデュースビルダーの両方がオプションのcapacityパラメーターを取り、
 * バッファーサイズを指定する。
 * バッファを使用するBlockingQueueと、指定された容量の場合と同様に、
 * 送信者は一時停止する前に複数の要素を送信でき、バッファがいっぱいになるとブロックされる。
 */
fun main() = runBlocking<Unit> {

    // 4つの容量を持つバッファリングされたチャネルを使用して、「送信」を5回表示する。
    // 最初の4つの要素がバッファに追加され、5番目の要素を送信しようとすると送信側が一時停止する。
    println("---Buffered channels---")

    // バッファーされたチャネルを作成
    val channel = Channel<Int>(4)

    // 送信者コルーチン作成
    val sender = launch {
        repeat(10) {
            // 送信前に値を表示
            println("Sending $it")

            // バッファがいっぱいになると停止する
            channel.send(it)
        }
    }
    // 受信せず1秒待機し、送信者コルーチンを終了する
    delay(1000)
    sender.cancel()
}

// 出力：
// ---Buffered channels---
// Sending 0
// Sending 1
// Sending 2
// Sending 3
// Sending 4