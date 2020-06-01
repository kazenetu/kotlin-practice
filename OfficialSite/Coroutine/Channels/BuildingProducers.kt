import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) send(x * x)
}

/*
 * コルーチン：チャネル：チャネルプロデューサーの構築
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 *
 * 並行コードでよく見られるプロデューサー/コンシューマーパターンの一部。
 * プロデューサー側で簡単に実行できる、プロデュースという便利なコルーチンビルダー
 * コンシューマー側のループを置き換える拡張関数consumerEachがある。
 */
fun main() = runBlocking<Unit> {

    // チャネルプロデューサーの構築
    println("---Building channel producers---")

    val squares = produceSquares()
    squares.consumeEach { println(it) }
    println("Done!")
}

// 出力：
