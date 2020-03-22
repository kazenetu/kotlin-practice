/*
 * バイナリサーチ用データクラス
 */
data class UserInfo(val name: String, val age: Int)

/*
 * コレクション：MutableList
 */
fun main() {

    // 初期化
    println("---Mutable List:Initialize---")
    println("mutableListOf(1, 2, 3, 4) = ${mutableListOf(1, 2, 3, 4)}")
    println("MutableList(10, {it}) = ${ MutableList(10, {it}) }")
    println("MutableList(10){it} = ${ MutableList(10){it} }")
    println("(1..10).toMutableList() = ${ (1..10).toMutableList() }")

    // 追加・削除した新しいリストを作成
    println("---plus and minus Operators---")
    println("(emptyList<String>() + \"ABC\").toMutableList() = ${ (emptyList<String>() + "ABC").toMutableList() }")
    println("mutableListOf(1, 2, 3, 4) - 1 = ${mutableListOf(1, 2, 3, 4) - 1}")

    // 更新系
    println("---Mutable List:write operations---")
    val writeList = mutableListOf(1, 2, 3)
    println("writeList = $writeList")

    println("> add")
    writeList.add(4)
    println("writeList.add(4) = $writeList")
    writeList.add(0, 5)  // パラメータが2つの場合は要素の挿入
    println("writeList.add(0, 5) = $writeList") 
    writeList.addAll(mutableListOf(15, 13, 12))
    println("writeList.addAll(mutableListOf(15, 13, 12)) = $writeList") 

    println("> update")
    writeList[0] = -1
    println("update \"writeList[0] = -1\" = $writeList") 

    println("> remove")
    writeList.removeAt(1)   // 指定した要素インデックスを削除する
    println("writeList.removeAt(1) = $writeList") 

    // ソート系
    println("---Mutable List:Sorting---")
    writeList.sort()
    println("writeList.sort() = $writeList") 
    writeList.sortDescending()
    println("writeList.sortDescending() = $writeList") 

    writeList.sortBy(){ it % 10 }
    println("writeList.sortBy(){ it % 10 } = $writeList") 
    writeList.sortByDescending(){ it % 10 }
    println("writeList.sortByDescending(){ it % 10 } = $writeList") 

    writeList.shuffle()
    println("writeList.shuffle() = $writeList") 
    writeList.reverse()
    println("writeList.reverse() = $writeList") 

    // 各要素へのアクセス
    println("---Mutable List:Access element---")
    val list = mutableListOf(1, 2, 3, 4)
    println("list = $list")

    println("> get element")
    println("list.get(0) = ${ list.get(0) }")
    println("list[0] = ${ list[0] }")
    println("list[0] = ${ list[0] }")

    println("> getOrNull")
    println("list.getOrNull(5) = ${ list.getOrNull(5) }")                 // getOrNull:要素インデックスが存在しない場合はnullを返す
    println("list.getOrNull(2) = ${ list.getOrNull(2) }")                 // getOrNull:要素インデックスが存在する場合は値を返す

    println("> getOrNull")
    println("list.getOrElse(2, {null}) = ${ list.getOrElse(2, {null}) }") // getOrElse:要素インデックスが存在する場合は値を返す
    println("list.getOrElse(5, {it}) = ${ list.getOrElse(5, {it}) }")     // getOrElse:要素インデックスが存在しない場合はit(5)を返す
    println("list.getOrElse(5, {null}) = ${ list.getOrElse(5, {null}) }") // getOrElse:要素インデックスが存在しない場合はnullを返す

    // リストの部分コピー(終了インデックス番号, 開始インデックス番号(含まない))
    println("---Mutable List:list parts---")
    println("mutableListOf(1, 2, 3, 4).subList(1, 3) = ${mutableListOf(1, 2, 3, 4).subList(1, 3)}")

    // 要素インデックスを取得
    println("---Mutable List:Linear search---")
    println("mutableListOf(1, 2, 3, 4, 1).indexOf(1) = ${mutableListOf(1, 2, 3, 4, 1).indexOf(1)}")
    println("mutableListOf(1, 2, 3, 4, 1).lastIndexOf(1) = ${mutableListOf(1, 2, 3, 4, 1).lastIndexOf(1)}")

    println("mutableListOf(1, 2, 3, 4, 1).indexOf(5) = ${mutableListOf(1, 2, 3, 4, 1).indexOf(5)}")           // 存在しない場合は-1
    println("mutableListOf(1, 2, 3, 4, 1).lastIndexOf(5) = ${mutableListOf(1, 2, 3, 4, 1).lastIndexOf(5)}")   // 存在しない場合は-1
    
    // 条件一致の要素インデックスを取得
    println("---Mutable List:Comparator binary search---")
    val users = mutableListOf(
        UserInfo("A",10),
        UserInfo("B",30),
        UserInfo("C",100)
    )
    println("users = $users")
    println("users.binarySearch(UserInfo(\"C\",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = ${ users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) }")

    // ソート済みのリストでバイナリサーチ
    println("---Mutable List:Binary search in sorted lists---")
    val binaryList = (1..20).toMutableList()
    binaryList.shuffle()    // 一旦バラバラにする
    println("binaryList.shuffle() = $binaryList")
    binaryList.sort()
    println("binaryList.sort() = $binaryList")
    println("binaryList.binarySearch(11) = ${ binaryList.binarySearch(11) }") // 要素インデックスを取得する

}

// 出力：
// ---Mutable List:Initialize---
// mutableListOf(1, 2, 3, 4) = [1, 2, 3, 4]
// MutableList(10, {it}) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// MutableList(10){it} = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// (1..10).toMutableList() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// ---plus and minus Operators---
// (emptyList<String>() + "ABC").toMutableList() = [ABC]
// mutableListOf(1, 2, 3, 4) - 1 = [2, 3, 4]
// ---Mutable List:write operations---
// writeList = [1, 2, 3]
// > add
// writeList.add(4) = [1, 2, 3, 4]
// writeList.add(0, 5) = [5, 1, 2, 3, 4]
// writeList.addAll(mutableListOf(15, 13, 12)) = [5, 1, 2, 3, 4, 15, 13, 12]
// > update
// update "writeList[0] = -1" = [-1, 1, 2, 3, 4, 15, 13, 12]
// > remove
// writeList.removeAt(1) = [-1, 2, 3, 4, 15, 13, 12]
// ---Mutable List:Sorting---
// writeList.sort() = [-1, 2, 3, 4, 12, 13, 15]
// writeList.sortDescending() = [15, 13, 12, 4, 3, 2, -1]
// writeList.sortBy(){ it % 10 } = [-1, 12, 2, 13, 3, 4, 15]
// writeList.sortByDescending(){ it % 10 } = [15, 4, 13, 3, 12, 2, -1]
// writeList.shuffle() = [13, 4, 2, 12, 3, -1, 15]
// writeList.reverse() = [15, -1, 3, 12, 2, 4, 13]
// ---Mutable List:Access element---
// list = [1, 2, 3, 4]
// > get element
// list.get(0) = 1
// list[0] = 1
// list[0] = 1
// > getOrNull
// list.getOrNull(5) = null
// list.getOrNull(2) = 3
// > getOrNull
// list.getOrElse(2, {null}) = 3
// list.getOrElse(5, {it}) = 5
// list.getOrElse(5, {null}) = null
// ---Mutable List:list parts---
// mutableListOf(1, 2, 3, 4).subList(1, 3) = [2, 3]
// ---Mutable List:Linear search---
// mutableListOf(1, 2, 3, 4, 1).indexOf(1) = 0
// mutableListOf(1, 2, 3, 4, 1).lastIndexOf(1) = 4
// mutableListOf(1, 2, 3, 4, 1).indexOf(5) = -1
// mutableListOf(1, 2, 3, 4, 1).lastIndexOf(5) = -1
// ---Mutable List:Comparator binary search---
// users = [UserInfo(name=A, age=10), UserInfo(name=B, age=30), UserInfo(name=C, age=100)]
// users.binarySearch(UserInfo("C",100), compareBy<UserInfo> { it.name }.thenBy{ it.age }) = 2
// ---Mutable List:Binary search in sorted lists---
// binaryList.shuffle() = [10, 11, 7, 15, 2, 9, 6, 1, 18, 14, 12, 3, 17, 20, 16, 4, 13, 19, 8, 5]
// binaryList.sort() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
// binaryList.binarySearch(11) = 10