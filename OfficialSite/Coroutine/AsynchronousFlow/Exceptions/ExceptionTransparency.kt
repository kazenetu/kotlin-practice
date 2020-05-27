import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

/*
 * コルーチン：非同期フロー：catchオペレータ
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * try-catchの代わりにcatchオペレータを利用することができる
 */
fun main() = runBlocking<Unit> {

    // 例外処理の定義順番
    println("---Exception transparency---")

    // catchオペレータ定義前の実行で例外発生：補足可能(map)
    println("> After catch operator:map")
    foo()
        .map { value ->
            check(value <= 1) { "Crashed on $value" }                 
            "string $value"
        }    
        .catch { e -> println("Caught $e") }
        .collect { value ->
            println(value) 
        }
    println("　")

    // catchオペレータ定義前の実行で例外発生：補足可能(onEach)
    println("> After catch operator:onEach")
    foo()
        .onEach { value ->
            check(value <= 1) { "Crashed on $value" }                 
        }    
        .catch { e -> println("Caught $e") }
        .collect { value ->
            println("string $value")
        }
    println("　")

    // catchオペレータ定義後の実行で例外発生：補足不可
    println("> Before catch operator")
    foo()
        .catch { e -> println("Caught $e") } // 以降の実行で発生した例外は補足できない
        .map { value ->
            check(value <= 1) { "Crashed on $value" }                 
            "string $value"
        }    
        .collect { value ->
            println(value) 
        }

}

// 出力：
// ---Exception transparency---
// > After catch operator:map
// Emitting 1
// string 1
// Emitting 2
// Caught java.lang.IllegalStateException: Crashed on 2
// 　
// > After catch operator:onEach
// Emitting 1
// string 1
// Emitting 2
// Caught java.lang.IllegalStateException: Crashed on 2
// 　
// > Before catch operator
// Emitting 1
// string 1
// Emitting 2
// Exception in thread "main" java.lang.IllegalStateException: Crashed on 2