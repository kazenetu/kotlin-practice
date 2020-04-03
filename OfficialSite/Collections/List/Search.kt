/*
 * バイナリサーチ用データクラス
 */
data class UserInfo(val name: String, val age: Int)

/*
 * コレクション：ReadOnlyList
 */
fun main() {

    // 要素インデックスを取得
    println("---ReadOnly List : Linear search---")
    println("listOf(1, 2, 3, 4, 1).indexOf(1) = ${listOf(1, 2, 3, 4, 1).indexOf(1)}")
    println("listOf(1, 2, 3, 4, 1).lastIndexOf(1) = ${listOf(1, 2, 3, 4, 1).lastIndexOf(1)}")
    println("　")

    println("listOf(1, 2, 3, 4, 1).indexOf(5) = ${listOf(1, 2, 3, 4, 1).indexOf(5)}")           // 存在しない場合は-1
    println("listOf(1, 2, 3, 4, 1).lastIndexOf(5) = ${listOf(1, 2, 3, 4, 1).lastIndexOf(5)}")   // 存在しない場合は-1
    println("　")
    
    // 条件一致の要素インデックスを取得
    println("---ReadOnly List : Comparator binary search---")
    val users = listOf(
        UserInfo("A",10),
        UserInfo("B",30),
        UserInfo("C",100)
    )
    println("users = $users")
    println("users.binarySearch(UserInfo(\"C\",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = ${ users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) }")

}

// 出力：
// ---ReadOnly List : Linear search---
// listOf(1, 2, 3, 4, 1).indexOf(1) = 0
// listOf(1, 2, 3, 4, 1).lastIndexOf(1) = 4
// 　
// listOf(1, 2, 3, 4, 1).indexOf(5) = -1
// listOf(1, 2, 3, 4, 1).lastIndexOf(5) = -1
// 　
// ---ReadOnly List : Comparator binary search---
// users = [UserInfo(name=A, age=10), UserInfo(name=B, age=30), UserInfo(name=C, age=100)]
// users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = 2
