import kotlinx.coroutines.*

/*
 * コルーチン：例外処理と監視：キャッチされなかった例外カスタマイズ
 */
fun main() = runBlocking<Unit> {

    // キャッチされなかった例外をコンソールに出力するデフォルトの動作をカスタマイズすることができる
    println("---CoroutineExceptionHandler---")

    // 例外ハンドラ
    val handler = CoroutineExceptionHandler { _, exception -> 
        println("CoroutineExceptionHandler got $exception") 
    }

    // ルートのコルーチンを起動
    val job = GlobalScope.launch(handler) { // root coroutine, running in GlobalScope
        throw AssertionError()
    }

    // 非同期実行はハンドラの効果なし
    // (常にすべての例外をキャッチし、結果のDeferredオブジェクトでそれらを表すため)
    val deferred = GlobalScope.async(handler) {
        // awaitが呼ばれるタイミングでコンソール出力される
        throw ArithmeticException()
    }
    joinAll(job, deferred)  
}

// 出力：
