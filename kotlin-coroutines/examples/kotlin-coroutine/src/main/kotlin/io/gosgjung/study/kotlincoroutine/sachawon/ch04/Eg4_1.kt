package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
    val time = measureTimeMillis {
        val one = selectOneAsync4_1()
        val two = selectTwoAsync4_1()
        runBlocking{
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

fun selectOneAsync4_1() = GlobalScope.async { selectOne4_1() } // 1)
fun selectTwoAsync4_1() = GlobalScope.async { selectTwo4_1() } // 1)

suspend fun selectOne4_1() : Int{
    delay(1000L)
    return 13
}

suspend fun selectTwo4_1() : Int{
    delay(1000L)
    return 29
}