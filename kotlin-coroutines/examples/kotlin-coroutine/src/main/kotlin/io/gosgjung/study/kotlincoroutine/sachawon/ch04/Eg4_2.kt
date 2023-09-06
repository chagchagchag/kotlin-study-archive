package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main(){
    try{
        val time = measureTimeMillis {
            val one = selectOneAsync4_2()   // 1)
            val two = selectTwoAsync4_2()   // 1)

            // 2)
            // Exception 이 발생했을 때 이미 비동기적으로 실행시킨 1) 의 구문이 실행되는가?
            println("=== my exception")
            throw Exception("my exception ===")

            runBlocking{
                println("The answer is ${one.await() + two.await()}")
            }
        }
        println("Completed in $time ms")
    } catch (e: Exception){ }

    runBlocking {
        delay(10000L)
    }
}

fun selectOneAsync4_2() = GlobalScope.async {// 1)
    println("start  >>> selectOneAsync4_2")
    val r = selectOne4_2()
    println("end    >>> selectOneAsync4_2")
    r
}

fun selectTwoAsync4_2() = GlobalScope.async { // 1)
    println("start  ### selectTwoAsync4_2")
    val r = selectTwo4_2()
    println("end    ### selectTwoAsync4_2")
    r
}

suspend fun selectOne4_2() : Int{
    delay(3000L)
    return 13
}

suspend fun selectTwo4_2() : Int{
    delay(3000L)
    return 29
}