import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1 
    while (true) {
        // 送信
        send(x++)

        // 0.5秒待機
        delay(100)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        println("Processor #$id received $msg")
    }    
}

/*
 * コルーチン：チャネル：同一チャネルの複数コルーチン分散
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 *
 * 複数のコルーチンが同じチャネルから受信し、それらの間で作業を分散するケース
 */
fun main() = runBlocking<Unit> {

    // 同一チャネルの複数コルーチン分散
    println("---Fan-out---")

    val producer = produceNumbers()
    repeat(5) { launchProcessor(it, producer) }

    // 9.5秒待機してチャネルを終了
    delay(950)
    producer.cancel()
}

// 出力：
// ---Fan-out---
// Processor #0 received 1
// Processor #0 received 2
// Processor #1 received 3
// Processor #2 received 4
// Processor #3 received 5
// Processor #4 received 6
// Processor #0 received 7
// Processor #1 received 8
// Processor #2 received 9
// Processor #3 received 10