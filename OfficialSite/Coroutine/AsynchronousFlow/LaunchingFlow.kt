import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Imitate a flow of events
fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(100) }

/*
 * コルーチン：非同期フロー：起動フロー
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * フローを使用して、なんらかのソースからの非同期イベントを表すことができる。
 * onEachオペレータは入ってくるイベントに対する反応をコードの一部に登録し、さらに作業を続ける関数の類似体である。
 * collectターミナルオペレーターを使用するとonEachオペレータやその後のコードはフローが収集されるまで待機する。
 *
 * launchInターミナルオペレータはコードの実行がすぐに続くように、別のコルーチンを実行する
 */
fun main() = runBlocking<Unit> {

    // 起動フロー
    println("---Launching flow---")

    // 入ってくるイベントに対する反応をコードの一部に登録し、さらに作業を続ける関数
    println("> onEach operator")
    events()
        .onEach { event -> println("Event: $event") }
        .collect() //処理が完了するまで待つ
    println("Done")
    println("　")

    // launchInターミナルオペレータはコードの実行がすぐに続くように、別のコルーチンを実行する
    println("> launchIn terminal operator")
    events()
        .onEach { event -> println("Event: $event") }
        .launchIn(this) // <--- 別のコルーチンで即時実行
    println("Done")

}

// 出力：
