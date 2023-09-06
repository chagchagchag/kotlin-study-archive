package io.gosgjung.study.kotlincoroutine.sachawon.ch04

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking <Unit>{
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY){ selectOne3_1() }
        val two = async(start = CoroutineStart.LAZY){ selectTwo3_1() }
        one.start()
        two.start()
        println(">>> result = ${one.await() + two.await()}")
    }
    println("time = ${time}")
    Dispatchers.Main
}

suspend fun selectOne3_1() : Int{
    println("selectOne3_1")
    delay(1000)
    return 13
}

suspend fun selectTwo3_1() : Int{
    println("selectTwo3_1")
    delay(1000)
    return 29
}