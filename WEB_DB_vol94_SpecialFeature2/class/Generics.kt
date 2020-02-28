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