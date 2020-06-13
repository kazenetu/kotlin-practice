import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

data class Ball(var hits: Int)

suspend fun player(name: String, table: Channel<Ball>) {
    for (ball in table) { //受信するまで待機
        // (ボールを)受信する
        ball.hits++
        println("$name $ball")

        // 300ミリ秒待ってから送信(ボールを返す)
        delay(300)
        table.send(ball)
    }
}

/*
 * コルーチン：チャネル：チャネルの公平性
 * 遅延値は、コルーチン間で単一の値を転送する便利な方法を提する。
 * チャネルは、値のストリームを転送する方法を提供する。
 */
fun main() = runBlocking<Unit> {

    // 「ping」コルーチンが最初に開始されるので、ボールを受け取る最初のコルーチン。
    // 「ping」コルーチンがテーブルに送り返した後、すぐにボールの受信を再開するが、
    // ボールはすでに「pong」コルーチンによって受信されている。
    println("---Channels are fair---")

    // ボールチャネル作成
    val table = Channel<Ball>()

    // プレイヤー作成
    launch { player("ping", table) }
    launch { player("pong", table) }

    // ボールチャネルを送信(ボールを投げる)
    table.send(Ball(0))

    // 1秒待機しすべて終了(ゲーム終了)
    delay(1000)
    coroutineContext.cancelChildren()
}

// 出力：
// ---Channels are fair---
// ping Ball(hits=1)
// pong Ball(hits=2)
// ping Ball(hits=3)
// pong Ball(hits=4)