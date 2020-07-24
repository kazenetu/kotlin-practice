import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.system.*

suspend fun massiveRun(action: suspend () -> Unit) {
    // コルーチン数
    val n = 100

    // 1コルーチンでの繰り返し回数
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")  
}

// アクター設定：アクターが処理するメッセージのクラス定義
sealed class CounterMsg

// アクター設定：カウント値の一方方向メッセージ
object IncCounter : CounterMsg()

// アクター設定：レスポンスが返ってくるリクエスト
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

// アクターコルーチンビルダーを使用してアクターを起動する関数の定義
fun CoroutineScope.counterActor() = actor<CounterMsg> {
    // アクターの状態
    var counter = 0

    // メッセージ処理
    for (msg in channel) {
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

/*
 * コルーチン：共有された変更可能な状態と並行性：アクター
 * 変更可能な共有状態へのアクセスの同期が問題となる
 */
fun main() = runBlocking<Unit> {

    // 解決策6
    // アクターは、コルーチンの組み合わせで構成エンティティ、このコルーチンに閉じ込められ、
    // カプセル化された状態、および他のコルーチンと通信するためのチャネル。
    // 単純なアクターは関数として記述できるが、複雑な状態のアクターはクラスに適している。
    // アクターのメールボックスチャネルをスコープに結合してメッセージを受信し、
    // チャネルを結果のジョブオブジェクトに結合するアクターコルーチンビルダーがある。
    // これにより、アクターへの単一参照をハンドルとして持ち運ぶことができる。
    // kotlinx.coroutines.channels.* のインポートが必要
    //
    // ・アクターはコルーチンであり、コルーチンは順次実行されるため、
    // 　特定のコルーチンへの状態の制限は、共有された変更可能な状態の問題の解決策として機能する。
    // ・実際、アクターは自身のプライベート状態を変更できるが、
    // 　メッセージを通じてのみ互いに​​影響し合うことができる。（ロックの必要性を回避）
    // ・アクターは負荷がかかった状態でロックするよりも効率的。
    // 　この場合、アクターは常に処理する必要があり、別のコンテキストに切り替える必要がないため。
    println("---Actors---")

    // アクター作成
    val counter = counterActor()

    withContext(Dispatchers.Default) {
        massiveRun {
            counter.send(IncCounter)
        }
    }

    // リクエストを送信してカウンタの値を受信
    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))

    // 最終の値を出力
    println("Counter = ${response.await()}")

    // アクターを閉じる：チャネルのcloce
    counter.close()

}

// 出力：
