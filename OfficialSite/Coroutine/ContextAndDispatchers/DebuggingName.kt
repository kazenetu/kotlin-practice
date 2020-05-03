import kotlinx.coroutines.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

/*
 * コルーチン：ディスパッチャーとスレッド：デバッグのためのコルーチンの命名
 *
 * ※実行時に「-Dkotlinx.coroutines.debug」を指定する
 */
fun main() = runBlocking(CoroutineName("main")) {

    // ログなどで使用するデフォルト名
    println("---Debugging coroutines and threads---")

    // 開始メッセージ
    log("Started main coroutine")

    // 非同期のコルーチン設定と実行
    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log("Computing v1")
        252
    }
    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log("Computing v2")
        6
    }

    // 非同期のコルーチンの実行を待って結果を出力
    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")    
}

// 出力：
// ---Debugging coroutines and threads---
// [main @main#1] Started main coroutine
// [main @v1coroutine#2] Computing v1
// [main @v2coroutine#3] Computing v2
// [main @main#1] The answer for v1 / v2 = 42