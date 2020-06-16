import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/*
 * コルーチン：チャネル：ティッカーチャネル
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 */
fun main() = runBlocking<Unit> {

    // 指定された遅延が経過するたびに生成される
    println("---Ticker channels---")

    // ティッカーチャネルを作成
    val tickerChannel = ticker(delayMillis = 100, initialDelayMillis = 0)

    // 初期遅延なし
    var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Initial element is available immediately: $nextElement")

    // 次回以降は100ミリ秒の遅延がある：50ミリ秒では取得不可
    nextElement = withTimeoutOrNull(50) { tickerChannel.receive() }
    println("Next element is not ready in 50 ms: $nextElement")

    // 次回以降は100ミリ秒の遅延がある：110ミリ秒(50ミリ秒+60ミリ秒)経過したので取得可能
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100 ms: $nextElement")

    // 高コストな処理
    println("Consumer pauses for 150ms")
    delay(150)

    // 次回以降は100ミリ秒の遅延がある：150ミリ秒経過したので取得可能
    nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Next element is available immediately after large consumer delay: $nextElement")

    // 次回以降は100ミリ秒の遅延がある：110ミリ秒(前回の150ミリ秒-100ミリ秒 + 60ミリ秒)経過したので取得可能
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() } 
    println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")

    // 終了
    tickerChannel.cancel()
}

// 出力：
