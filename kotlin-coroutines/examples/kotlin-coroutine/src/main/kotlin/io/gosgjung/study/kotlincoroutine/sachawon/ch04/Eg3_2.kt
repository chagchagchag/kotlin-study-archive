package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY){ selectOne3_2() } // 1)
        val two = async(start = CoroutineStart.LAZY){ selectTwo3_2() } // 1)
        println(">>> result = ${one.await() + two.await()}") // 2) 여기서 실행된다.
    }
    println("time = ${time}")
}

suspend fun selectOne3_2() : Int{
    println("selectOne3_2")
    delay(1000)
    return 13
}

suspend fun selectTwo3_2() : Int{
    println("selectTwo3_2")
    delay(1000)
    return 29
}