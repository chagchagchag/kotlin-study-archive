package io.gosgjung.study.kotlincoroutine.sachawon.ch06

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")

    launch{
        println("My job is ${coroutineContext[Job]}")
    }

    async {
        println("My job is ${coroutineContext[Job]}")
        println("isActive ? ${isActive}")
        println("isActive ? ${coroutineContext[Job]?.isActive}")
    }

}