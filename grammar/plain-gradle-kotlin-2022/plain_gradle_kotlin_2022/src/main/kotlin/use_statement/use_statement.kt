package use_statement

import java.io.File

fun main(){
    println(">>> ")
    File("t1.txt").inputStream()
        .use {
            it.bufferedReader()
                .lineSequence()
                .forEach (::println)
        }

    // 아래 코드는 에러를 낸다.
//    println(">>> ")
//    val sequence: Sequence<String> =
//        File("t1.txt").inputStream()
//            .use {
//                it.bufferedReader()
//                    .lineSequence()
//            }
//    sequence.forEach(::println)

    println()
    println(">>> ")
    val lines: List<String> =
        File("t1.txt")
            .inputStream()
            .use {
                it.bufferedReader()
                    .lineSequence()
                    .toList()
            }

    println("""
        lines = 
         $lines
    """.trimIndent())

    println()
    println(">>> useLines {...} 예제")
    File("t1.txt")
        .useLines { it.forEach(::println) }
}

