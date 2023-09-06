package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum5_1()}")
    }
    println("Completed in $time ms")
}

suspend fun concurrentSum5_1(): Int = coroutineScope {
    val one = async { selectOne5_1() }
    val two = async { selectTwo5_1() }

    one.await() + two.await()
}

suspend fun selectOne5_1(): Int{
    delay(3000L)
    return 13
}

suspend fun selectTwo5_1(): Int{
    delay(3000L)
    return 29
}
