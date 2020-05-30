import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.channels.*

// Imitate a flow of events
fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(100) }

/*
 * コルーチン：チャネル：基本
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 * send/receiveを使用する
 */
fun main() = runBlocking<Unit> {

    // チャネルの基本
    println("---Channel basics---")

    val channel = Channel<Int>()
    launch {
        // 重い処理を実行し、結果を送信する
        for (x in 1..5) channel.send(x * x)
    }
    // 受け取った値を表示
    repeat(5) { println(channel.receive()) }
    println("Done!")
}

// 出力：
