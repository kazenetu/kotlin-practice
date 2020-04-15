/*
 * 内部クラスを内包するクラス
 * ※参考にした書籍ではinnerキーワードのみ紹介
 */
class Container {
    private val id=1

    /*
     * 内部クラス
     */
    inner class Inner {
	    private val id=10

        /*
         * コンテナクラスのIDを取得する
         */
        fun getContainerId():Int = this@Container.id

        /*
         * 自身のIDを取得する
         */
        fun getId():Int = id
    }
}

/*
 * 内部クラスを内包するクラス：内部クラスインスタンスをプロパティにもつ
 */
class ContainerProperty {
    private val id=1
    private val child = Inner()

    /*
     * 内部クラスのメソッドをコール
     */
    fun getContainerId():Int = child.getContainerId()
    fun getId():Int = child.getId()

    /*
     * 内部クラス
     */
    private inner class Inner {
	    private val id=10

        /*
         * コンテナクラスのIDを取得する
         */
        fun getContainerId():Int = this@ContainerProperty.id

        /*
         * 自身のIDを取得する
         */
        fun getId():Int = id
    }
}

/*
 * 内部クラスを内包するクラス：内部クラスのネスト
 */
class Container2LevelNest {
    private val id=1
    private val child = Inner()

    /*
     * 内部クラスのメソッドをコール
     */
    fun getContainerId():Int = child.getContainerId()
    fun getId():Int = child.getId()

    /*
     * 内部クラス
     */
    private inner class Inner {
	    private val id=10
        private val child = Nest()

        /*
         * ２段階目の内部クラスのメソッドをコール
         */
        fun getContainerId():Int = child.getContainerId()
        fun getId():Int = child.getId()

        /*
         * ２段階目の内部クラス
         */
        inner class Nest {
            /*
             * コンテナクラスのIDを取得する
             */
            fun getContainerId():Int = this@Container2LevelNest.id

            /*
             * 親のIDを暗黙的に取得する
             */
            fun getId():Int = id
        }
    }
}

/*
 * エントリポイント
 */
fun main() {

    // 内部クラスのインスタンスを作成してメソッドを呼び出す
    println("----InnerClass---")
    val innerClass = Container().Inner()
    println("innerClass.getContainerId():${innerClass.getContainerId()}")
    println("innerClass.getId():${innerClass.getId()}")
    println("　")

    // 内部クラスは非公開とし、内包クラスインスタンスを経由してメソッド呼び出し
    println("----private InnerClass---")
    val containerProperty = ContainerProperty()
    println("containerProperty.getContainerId():${containerProperty.getContainerId()}")
    println("containerProperty.getId():${containerProperty.getId()}")
    println("　")

    // 内部クラスは非公開とし、内包クラスインスタンスを経由してメソッド呼び出し：内部クラスの多段タイプ
    println("----Nested InnerClass---")
    val container2LevelNest = Container2LevelNest()
    println("container2LevelNest.getContainerId():${container2LevelNest.getContainerId()}")
    println("container2LevelNest.getId():${container2LevelNest.getId()}")
}

// 出力：
// ----InnerClass---
// innerClass.getContainerId():1
// innerClass.getId():10
// 　
// ----private InnerClass---
// containerProperty.getContainerId():1
// containerProperty.getId():10
// 　
// ----Nested InnerClass---
// container2LevelNest.getContainerId():1
// container2LevelNest.getId():10
