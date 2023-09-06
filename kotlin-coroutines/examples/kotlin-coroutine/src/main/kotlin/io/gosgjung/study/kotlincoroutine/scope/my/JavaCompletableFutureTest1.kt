package io.gosgjung.study.kotlincoroutine.scope.my

import kotlinx.coroutines.Dispatchers
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

class JavaCompletableFutureTest1 {
    val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun cook(){
        Thread.sleep(3000)
        logger.info("cook ... ")
    }

    fun washingDishes(){
        Thread.sleep(5000)
        logger.info("washingDishes ... ")
    }

    fun eat(){
        Thread.sleep(2000)
        logger.info("eat ... ")
    }



}

fun main(args: Array<String>){
    val startMs = System.currentTimeMillis()
    val t: JavaCompletableFutureTest1 = JavaCompletableFutureTest1()

    val job1 = CompletableFuture.supplyAsync{t.cook()}
    val job2 = CompletableFuture.supplyAsync{t.washingDishes()}
    val job3 = CompletableFuture.supplyAsync{t.eat()}


    job1.thenCompose {
        CompletableFuture.supplyAsync { t.washingDishes() }
    }.get()

    CompletableFuture.supplyAsync {
        CompletableFuture.supplyAsync { t.cook() }
        CompletableFuture.supplyAsync { t.washingDishes() }
    }
    Dispatchers.IO

    Executors.newFixedThreadPool(1)

//    job1.join()
    println("(1) >> ${System.currentTimeMillis() - startMs}")
//
//    job2.join()
//    println("(2) >> ${System.currentTimeMillis() - startMs}")
//
//    job3.join()
//    println("(3) >> ${System.currentTimeMillis() - startMs}")

    val cost = System.currentTimeMillis() - startMs
    println("cost = $cost")
}