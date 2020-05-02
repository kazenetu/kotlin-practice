import kotlinx.coroutines.*

/*
 * コルーチン：ディスパッチャーとスレッド：ジョブの終了確認
 * Job.join()で実行完了まで待つ
 */
fun main() = runBlocking {

    // ジョブの実行完了まで待つ
    println("---Parental responsibilities---")

    // ジョブの定義と実行
    val request = launch {
        // 3つのジョブを作成する
        repeat(3) { i -> 
            launch  {
                 // それぞれ 200ms, 400ms, 600ms 待機
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }

    // ジョブの完了まで待つ
    request.join()
    println("Now processing of the request is complete")
}

// 出力：
// ---Parental responsibilities---
// request: I'm done and I don't explicitly join my children that are still active
// Coroutine 0 is done
// Coroutine 1 is done
// Coroutine 2 is done
// Now processing of the request is complete