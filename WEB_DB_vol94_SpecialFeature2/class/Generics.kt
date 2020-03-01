/*
 * クラスの型パラメータ
 */
class GenericsClass<T>(var item: T) {

    /*
     * 型パラメータ付きクラスのコピー
     */
    fun copy(): GenericsClass<T> {
        return GenericsClass(this.item)
    }

    /*
     * クラスメソッド
     */
    companion object {
        /*
         * メソッドの型パラメータ：インスタンスの作成
         * ※funキーワードのあとに型パラメータを定義する
         */
         fun <T> create(value: T): GenericsClass<T> {
            return GenericsClass(value)
	    }  
    } 
}

/*
 * 上限制約用インターフェイス
 */
interface Param {
    val text: String
}

/*
 * クラスの型パラメータ：上限制約
 */
class ParamClass<T>(private val item: T): Param {
    override val text: String
        get() {
            return "$item"
        }
}

/*
 * クラスの型パラメータ:インターフェイスで上限制約
 */
class GenericsClassParam<T:Param>(val item: T) 
{
    fun getText() = item.text
}

/*
 * 複数の上限制約用インターフェイス：型タイプ
 */
interface ItemType {
    val type: String
}

/*
 * 複数の上限制約用インターフェイス：値
 */
interface ItemValue {
    val value: Any
}

/*
 * 複数の上限制約用クラスInt
 */
class IntClass(override val value:Int): ItemType, ItemValue {
    override val type: String = "Int"
}

/*
 * 複数の上限制約用クラスString
 */
class StringClass(override val value:String): ItemType, ItemValue {
    override val type: String = "String"
}

/*
 * クラスの型パラメータ:複数の上限制約
 */
class GenericsClassWhere<T>(val item: T) 
	where T:ItemType,T:ItemValue
{
    fun getText() = "${item.type}:${item.value}"
}


/*
 * エントリポイント
 */
fun main() {

    // Intを指定
    println("----GenericsClass<Int>---")
    val genericsClass = GenericsClass(10)
    val genericsClassCopy = genericsClass.copy()
    val genericsClassCreate = GenericsClass.create(10)
    println("genericsClass.item:${genericsClass.item}")
    println("genericsClassCopy.item:${genericsClassCopy.item}")
    println("genericsClassCreate.item:${genericsClassCreate.item}")
    genericsClassCopy.item = 1000
    println("changed genericsClassCopy.item! genericsClass.item:${genericsClass.item}")
    println("genericsClassCopy == genericsClass: ${genericsClassCopy == genericsClass}")
    println("genericsClassCreate == genericsClass: ${genericsClassCreate == genericsClass}")

    // Stringを指定
    println("----GenericsClass<String>---")
    val genericsClassString = GenericsClass("ABC")
    val genericsClassCopyString = genericsClassString.copy()
    val genericsClassCreateString = GenericsClass.create("XYZ")
    println("genericsClassString.item:${genericsClassString.item}")
    println("genericsClassCopyString.item:${genericsClassCopyString.item}")
    println("genericsClassCreateString.item:${genericsClassCreateString.item}")
    genericsClassCopyString.item = "DEF"
    println("changed genericsClassCopy.item! genericsClassString.item:${genericsClassString.item}")
    println("genericsClassCopyString == genericsClassString: ${genericsClassCopyString == genericsClassString}")
    println("genericsClassCreateString == genericsClassString: ${genericsClassCreateString == genericsClassString}")

    // インターフェイスを上限制約：Stringを指定
    println("----GenericsClassParam---")
    val genericsClassParam = GenericsClassParam(ParamClass("AAA"))
    println("genericsClassParam.text:${genericsClassParam.getText()}")

    // 複数の上限制約
    println("----GenericsClassWhere---")
    val genericsClassWhere = GenericsClassWhere(IntClass(10))
    println("genericsClassWhere.text:${genericsClassWhere.getText()}")
    val genericsClassWhereString = GenericsClassWhere(StringClass("ABC"))
    println("genericsClassWhereString.text:${genericsClassWhereString.getText()}")

}

// 出力：
// ----GenericsClass<Int>---
// genericsClass.item:10
// genericsClassCopy.item:10
// genericsClassCreate.item:10
// changed genericsClassCopy.item! genericsClass.item:10
// genericsClassCopy == genericsClass: false
// genericsClassCreate == genericsClass: false
// ----GenericsClass<String>---
// genericsClassString.item:ABC
// genericsClassCopyString.item:ABC
// genericsClassCreateString.item:XYZ
// changed genericsClassCopy.item! genericsClassString.item:ABC
// genericsClassCopyString == genericsClassString: false
// genericsClassCreateString == genericsClassString: false
// ----GenericsClassParam---
// genericsClassParam.text:AAA
// ----GenericsClassWhere---
// genericsClassWhere.text:Int:10
// genericsClassWhereString.text:String:ABC