/*
 * プライマリコンストラクタ
 */
class PrimaryConstructor(name: String) {
    init {
        // プライマリコンストラクタのイニシャライザブロック(初期化ブロック)
        println("PrimaryConstructor:name is $name")
    }
}

/*
 * セカンダリコンストラクタ
 */
class SecondaryConstructor(name: String) {
    init {
        // プライマリコンストラクタのイニシャライザブロック(初期化ブロック)
        println("PrimaryConstructor:name is $name")
    }

    // セカンダリコンストラクタ(プライマリコンストラクタを呼び出す)
    constructor(name: String, age: Int): this(name) {
        println("SecondaryConstructor:age is $age")
    }
}

/*
 * エントリポイント
 */
fun main() {

    // プライマリコンストラクタ
    println("----Primary Constructor---")
    val primary = PrimaryConstructor("ABC")

    // セカンダリコンストラクタ
    println("----Secondary Constructor---")
    val secondary = SecondaryConstructor("CDE", 10)
}

// 出力：
// ----Primary Constructor---
// PrimaryConstructor:name is ABC
// ----Secondary Constructor---
// PrimaryConstructor:name is CDE
// SecondaryConstructor:age is 10