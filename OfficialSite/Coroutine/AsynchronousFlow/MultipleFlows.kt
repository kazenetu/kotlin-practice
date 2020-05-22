import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Sequence<Int> = sequence { // シーケンスビルダー
    // 毎回計算に100ミリ秒かかる
    for (i in 1..3) {
        // 何かの処理を行ったとして100ミリ秒待つ
        Thread.sleep(100)

        // 次の値を生成
        yield(i)
    }
}

/*
 * コルーチン：非同期フロー：複数フロー作成方法
 */
fun main() {

    // 複数フローの作成方法
    println("---Composing multiple flows---")

    // 値の合成
    println("> Zip")
    val nums = (1..3).asFlow()
    val strs = flowOf("one", "two", "three")
    nums.zip(strs) { a, b -> "$a -> $b" } 
        .collect { println(it) }
    println("　")
    
    // 組み合わせ：2つの要素の順次組み合わせが出力される
    println("> Combine")
    val nums2 = (1..3).asFlow().onEach { delay(300) } // 常に300ミリ秒待つ
    val strs2 = flowOf("one", "two", "three").onEach { delay(400) } // 常に400ミリ秒待つ
    val startTime = System.currentTimeMillis() // 実行開始時間退避
    nums2.combine(strs2) { a, b -> "$a -> $b" } 
        .collect { value ->
            println("$value at ${System.currentTimeMillis() - startTime} ms from start") 
        } 
    println("　")

}

// 出力：
