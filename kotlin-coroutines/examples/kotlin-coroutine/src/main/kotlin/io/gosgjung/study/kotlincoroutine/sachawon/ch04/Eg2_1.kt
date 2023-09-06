package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        val one = async { selectSomething1() } // 1)
        val two = async { selectSomething2() } // 2)
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun selectSomething1(): Int{
    println("select data (1)")
    delay(1000L)
    return 13
}

suspend fun selectSomething2(): Int{
    println("select data (2)")
    delay(1000L)
    return 29
}