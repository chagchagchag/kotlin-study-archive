package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    try{
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum5_2()}")
        }
        println("Completed in $time ms")
    } catch (e: Exception){

    }

    runBlocking {
        delay(10000L)
    }

}

suspend fun concurrentSum5_2(): Int = coroutineScope {
    val one = async { selectOne5_2() }
    val two = async { selectTwo5_2() }

    delay(100L)
    println("Exception!! ")
    throw Exception() // 1)

    one.await() + two.await()
}

suspend fun selectOne5_2(): Int{
    println(">>>    start, selectOne5_2")
    delay(3000L)
    println(">>>    end, selectOne5_2")
    return 13
}

suspend fun selectTwo5_2(): Int{
    println("###    start, selectTwo5_2")
    delay(3000L)
    println("###    end, selectTwo5_2")
    return 29
}