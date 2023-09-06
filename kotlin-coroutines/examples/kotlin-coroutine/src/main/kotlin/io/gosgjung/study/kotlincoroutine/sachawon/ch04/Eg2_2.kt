package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        val one = async { selectSomething1_2() } // 1)
        val one_result = one.await()
        val two = async { selectSomething2_2() } // 2)
        println("The answer is ${one_result + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun selectSomething1_2(): Int{
    println("select data (1)")
    delay(1000L)
    return 13
}

suspend fun selectSomething2_2(): Int{
    println("select data (2)")
    delay(1000L)
    return 29
}