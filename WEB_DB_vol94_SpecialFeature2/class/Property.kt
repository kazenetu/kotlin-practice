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

    println("----update prop.age---")
    prop.age = 30
    println(prop.ageString)
    println(prop.ageStringFixed)

    // パラメータでプロパティ定義
    println("----ParamPropertyClass---")
    val paramProp = ParamPropertyClass(20)
    println(paramProp.ageString)

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
// ----update prop.age---
// >> set 30
// >> return 30
// age is 30
// age is 20
// ----ParamPropertyClass---
// age is 20
// ----update paramProp.age---
// age is 30