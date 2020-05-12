import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun performRequest(request: Int): String {

    // なにかしらの処理
    delay(1000)
    
    return "response $request"
}

/*
 * コルーチン：非同期フロー：中間オペレーション
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * コレクションやシーケンスの場合と同じように、フローは演算子を使用して変換できる
 * 演算子：mapやfilterなど
 */
fun main() = runBlocking<Unit> {
    
    // 中間オペレーション
    println("---Intermediate flow operators---")

    // 変換メソッドを介してフロー実行
    (1..3).asFlow() 
        .map { request -> performRequest(request) }
        .collect { response -> println(response) }
}

// 出力：
// ---Intermediate flow operators---
// response 1
// response 2
// response 3