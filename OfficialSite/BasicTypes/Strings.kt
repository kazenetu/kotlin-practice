/*
 * 基本型：文字列型
 */
fun main() {

    // 文字列型
    println("---Strings---")
    val s = "Hello, world!"
    println("single line = $s")

    val textln = "Hello,\nworld!"
    println("multi line ln =")
    println(textln)

    val multiLine = """
    Line1
    Line2
      Line3
    """
    println("multi line =")
    println(multiLine)

    val multiLineTrim = """
    |Line1
    |Line2
    |  Line3
    """.trimMargin()
    println("multi line trimMargin('|') =")
    println(multiLineTrim)

    val multiLineTrimlt = """
        <Line1
        <Line2
        <  Line3
    """.trimMargin("<")
    println("multi line trimMargin('<') =")
    println(multiLineTrimlt)
    println("　")

    println("---access character---")
    val accesscharacter = "abc"
    for (c in accesscharacter) {
        println(c)
    }

}

// 出力：
// ---Strings---
// single line = Hello, world!
// multi line ln =
// Hello,
// world!
// multi line =
//
//     Line1
//     Line2
//       Line3
//
// multi line trimMargin('|') =
// Line1
// Line2
//   Line3
// multi line trimMargin('<') =
// Line1
// Line2
//   Line3
// 　
// ---access character---
// a
// b
// c