/*
 * コレクション：MutableList
 */
fun main() {

    // 更新系
    println("---Mutable List : write operations---")
    val writeList = mutableListOf(1, 2, 3)
    println("writeList = $writeList")
    println("　")

    println("> add")
    writeList.add(4)
    println("writeList.add(4) = $writeList")
    writeList.add(0, 5)  // パラメータが2つの場合は要素の挿入
    println("writeList.add(0, 5) = $writeList") 
    writeList.addAll(mutableListOf(15, 13, 12))
    println("writeList.addAll(mutableListOf(15, 13, 12)) = $writeList") 
    println("　")

    println("> update")
    writeList[0] = -1
    println("update \"writeList[0] = -1\" = $writeList") 
    println("　")

    println("> remove")
    writeList.removeAt(1)   // 指定した要素インデックスを削除する
    println("writeList.removeAt(1) = $writeList") 
    println("　")

    // ソート系
    println("---Mutable List : Sorting---")
    writeList.sort()
    println("writeList.sort() = $writeList") 
    writeList.sortDescending()
    println("writeList.sortDescending() = $writeList") 
    println("　")

    writeList.sortBy(){ it % 10 }
    println("writeList.sortBy(){ it % 10 } = $writeList") 
    writeList.sortByDescending(){ it % 10 }
    println("writeList.sortByDescending(){ it % 10 } = $writeList") 
    println("　")

    writeList.shuffle()
    println("writeList.shuffle() = $writeList") 
    writeList.reverse()
    println("writeList.reverse() = $writeList") 

}

// 出力：
// ---Mutable List : write operations---
// writeList = [1, 2, 3]
// 　
// > add
// writeList.add(4) = [1, 2, 3, 4]
// writeList.add(0, 5) = [5, 1, 2, 3, 4]
// writeList.addAll(mutableListOf(15, 13, 12)) = [5, 1, 2, 3, 4, 15, 13, 12]
// 　
// > update
// update "writeList[0] = -1" = [-1, 1, 2, 3, 4, 15, 13, 12]
// 　
// > remove
// writeList.removeAt(1) = [-1, 2, 3, 4, 15, 13, 12]
// 　
// ---Mutable List : Sorting---
// writeList.sort() = [-1, 2, 3, 4, 12, 13, 15]
// writeList.sortDescending() = [15, 13, 12, 4, 3, 2, -1]
// 　
// writeList.sortBy(){ it % 10 } = [-1, 12, 2, 13, 3, 4, 15]
// writeList.sortByDescending(){ it % 10 } = [15, 4, 13, 3, 12, 2, -1]
// 　
// writeList.shuffle() = [3, 2, 13, 15, 4, 12, -1]
// writeList.reverse() = [-1, 12, 4, 15, 13, 2, 3]
