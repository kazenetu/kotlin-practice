import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(s)
    }
}

/*
 * コルーチン：チャネル：同一チャネルの複数コルーチン送信
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 *
 * 複数のコルーチンが同じチャネルに送信するケース
 */
fun main() = runBlocking<Unit> {

    // 同一チャネルの複数コルーチン送信
    println("---Fan-in---")

    val channel = Channel<String>()
    launch { sendString(channel, "foo", 200L) }
    launch { sendString(channel, "BAR!", 500L) }

    // 6回受信してチャネルを終了
    repeat(6) {
        println(channel.receive())
    }
    coroutineContext.cancelChildren()
}

// 出力：
