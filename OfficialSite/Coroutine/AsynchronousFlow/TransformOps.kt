import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun performRequest(request: Int): String {

    // なにかしらの処理
    delay(1000)
    
    return "response $request"
}

/*
 * コルーチン：非同期フロー：変換演算子
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * 長時間実行される非同期リクエストを実行する前に文字列を発行し、responseに返すことができる
 * 
 */
fun main() = runBlocking<Unit> {

    // 変換演算子
    println("---Transform operator---")

    // 2種類のresponseを返す
    (1..3).asFlow()
        .transform { request ->
            emit("Making request $request") 
            emit(performRequest(request)) 
        }
        .collect { response -> println(response) }
}

// 出力：
// ---Transform operator---
// Making request 1
// response 1
// Making request 2
// response 2
// Making request 3
// response 3