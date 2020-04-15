/*
 * プロパティ実装テストクラス
 */
class PropertyTestClass(age: Int) {
    
    /*
     * 年齢
     * アクセサ上でプロパティを参照する場合は
     * field(バッキングフィールド)を使用する
     */
    var age: Int = 0
        get() {
            println(">> return $field")
            return field
        }
        set(value) {
            field = value
            println(">> set $field")
        }

    /*
     * 年齢の文字列:アクセサ設定(呼び出しのたびに再評価)
     */
    val ageString: String
        get() {
            return "age is $age"
        }

    /*
     * 年齢の文字列:アクセサ未設定(インスタンス生成時に固定)
     */
    val ageStringFixed = "age is $age"

    init {
        // プライマリコンストラクタのイニシャライザブロック(初期化ブロック)
        this.age = age
    }
}

/*
 * プロパティ定義と同時に初期化
 */
class InitializeProperty(age: Int) {
    // パラメータをそのまま初期値とする
    var age = age

    /*
     * 年齢の文字列:アクセサ設定(呼び出しのたびに再評価)
     */
    val ageString: String
        get() {
            return "age is $age"
        }
}

/*
 * パラメータでプロパティ定義
 */
class ParamPropertyClass(var age: Int) {
    /*
     * 年齢の文字列:アクセサ設定(呼び出しのたびに再評価)
     */
    val ageString: String
        get() {
            return "age is $age"
        }
}

/*
 * エントリポイント
 */
fun main() {

    // プロパティテスト
    println("----PropertyTestClass---")
    val prop = PropertyTestClass(20)
    println(prop.ageString)
    println(prop.ageStringFixed)
    println("　")

    println("----update prop.age---")
    prop.age = 30
    println(prop.ageString)
    println(prop.ageStringFixed)
    println("　")

    // プロパティ宣言と初期化を同時に実行
    println("----InitializeProperty---")
    val initProp = InitializeProperty(20)
    println(initProp.ageString)
    println("　")

    println("----update initProp.age---")
    initProp.age = 30
    println(initProp.ageString)
    println("　")

    // パラメータでプロパティ定義
    println("----ParamPropertyClass---")
    val paramProp = ParamPropertyClass(20)
    println(paramProp.ageString)
    println("　")

    println("----update paramProp.age---")
    paramProp.age = 30
    println(paramProp.ageString)
}

// 出力：
// ----PropertyTestClass---
// >> set 20
// >> return 20
// age is 20
// age is 20
// 　
// ----update prop.age---
// >> set 30
// >> return 30
// age is 30
// age is 20
// 　
// ----InitializeProperty---
// age is 20
// 　
// ----update initProp.age---
// age is 30
// 　
// ----ParamPropertyClass---
// age is 20
// 　
// ----update paramProp.age---
// age is 30