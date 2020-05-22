import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First") 
    
    delay(500)

    emit("$i: Second")    
}
/*
 * コルーチン：非同期フロー：フローの平坦化
 */
fun main() {

    // フローの平坦化
    println("---Flattening flows---")

    // 連結モード シーケンシャルに実行
    println("> flatMapConcat")
    val startTime = System.currentTimeMillis() // 実行開始時間退避
    (1..3).asFlow().onEach { delay(100) } // 常に100ミリ秒待つ
        .flatMapConcat { requestFlow(it) }                                                                           
        .collect { value -> 
            println("$value at ${System.currentTimeMillis() - startTime} ms from start") 
        } 
    println("　")
    
    // すべての着信フローを同時に収集し、それらの値を単一のフローにマージ emitごとに実行
    println("> flatMapMerge")
    val startTime2 = System.currentTimeMillis() // 実行開始時間退避
    (1..3).asFlow().onEach { delay(100) } // 常に100ミリ秒待つ
    .flatMapMerge { requestFlow(it) }                                                                           
    .collect { value -> 
        println("$value at ${System.currentTimeMillis() - startTime2} ms from start") 
    } 
    println("　")

    // 「最新」の平坦化モード 
    // 新しいフローが発行されるとすぐに前のフローのコレクションがキャンセルされる
    println("> flatMapLatest")
    val startTime3 = System.currentTimeMillis()  // 実行開始時間退避
    (1..3).asFlow().onEach { delay(100) } // 常に100ミリ秒待つ
        .flatMapLatest { requestFlow(it) }                                                                           
        .collect { value -> 
            println("$value at ${System.currentTimeMillis() - startTime3} ms from start") 
        }
    println("　")

}

// 出力：
