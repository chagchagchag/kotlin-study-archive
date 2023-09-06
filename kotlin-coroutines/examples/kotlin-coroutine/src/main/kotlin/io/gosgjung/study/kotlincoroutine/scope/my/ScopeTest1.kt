package io.gosgjung.study.kotlincoroutine.scope.my

import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

class ScopeTest1 {
    val logger : Logger = LoggerFactory.getLogger(javaClass)

    suspend fun cook(){
        delay(3000)
        logger.info("cook >> ")
    }

    suspend fun washingDishes(){
        delay(5000)
        logger.info("washingDishes >> ")
    }

    suspend fun eat(){
        delay(2000)
        logger.info("eat >> ")
        val a = newFixedThreadPoolContext(1, "aaaaa")
        a.close()

    }
}

fun main(args: Array<String>){
    val time = measureTimeMillis {
        val c = ScopeTest1()

        val jobA = CoroutineScope(Dispatchers.IO).async {
            this.async{ c.cook() }.start()
            this.async { c.washingDishes() }.start()
        }
        val jobB = CoroutineScope(Dispatchers.IO).async {
            c.eat()
        }

        runBlocking {
            jobA.await()
            jobB.await()
        }
    }

    println("time = $time")

    val a = newFixedThreadPoolContext(1, "aaaaa")
}