import kotlinx.coroutines.*

/*
 * コルーチン：ディスパッチャーとスレッド
 *
 * コルーチンコンテキストは、さまざまな要素のセット。
 * （主な要素はコルーチンのジョブとそのディスパッチャー）
 * コルーチンコンテキストには、対応するコルーチンがその実行に使用するスレッドを決定するコルーチンディスパッチャーが含まれている。
 */
fun main() = runBlocking<Unit> {
    
    println("---Dispatchers and threads---")

    // 指定なし：runBlockingで実行されるメインコルーチンのコンテキストを継承
    launch {
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }

    // Dispatchers.Unconfined：特定のスレッドに限定させない
    // 一度停止させて再開した場合は別スレッドに切り替わっている可能性あり
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }

    // Dispatchers.Default:GlobalScopeでコルーチンが起動されるときに使用されるデフォルトのディスパッチャー
    launch(Dispatchers.Default) { 
        println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }

    // newSingleThreadContext:コルーチンが実行するスレッド作成。
    // 専用スレッドは非常に高価なリソース。
    // 実際のアプリケーションでは、close 関数を使用して解放するか、不要になったときに解放するか、最上位の変数に格納してアプリケーション全体で再利用する必要がある。
    launch(newSingleThreadContext("MyOwnThread")) {
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    } 
}

// 出力：
