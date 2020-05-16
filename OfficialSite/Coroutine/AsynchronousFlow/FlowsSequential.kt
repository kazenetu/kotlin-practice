import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
 * コルーチン：非同期フロー：順次処理
 * コールドストリーム：受信しないかぎり動作しない
 * 必ずコルーチンスコープになるため閉じ忘れがない
 *
 * 複数のフローを操作する特別な演算子を使用しない限り、フローの個々の収集は順次実行される。
 * デフォルトでは、新しいコルーチンは起動されない。
 * 放出された各値は、上流から下流までのすべての中間オペレーターによって処理され、その後端末オペレーターに配信される。
 */
fun main() = runBlocking<Unit> {

    // 順次処理
    println("---Flows are sequential---")

    // 上から順次実行
    (1..5).asFlow()
        .filter {
            println("Filter $it")

            // 偶数のみ次の処理を実行
            it % 2 == 0 
        }              
        .map { 
            println("Map $it")

            // 「string $it」を次の処理に渡す
            "string $it"
        }.collect { 
            println("Collect $it")
        }
}

// 出力：
// ---Flows are sequential---
// Filter 1
// Filter 2
// Map 2
// Collect string 2
// Filter 3
// Filter 4
// Map 4
// Collect string 4
// Filter 5