package io.gosgjung.study.kotlincoroutine.sachawon.ch06

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    launch {
        println("main run Blocking : I'm working in thread ${Thread.currentThread().name}")
    }

    launch (Dispatchers.Unconfined){
        println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
    }

    launch (Dispatchers.Default){
        println("Default : I'm working in thread ${Thread.currentThread().name}")
    }

//    launch (newSingleThreadContext("MyOwnThread")){
//        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//    }

    newSingleThreadContext("MyOwnThread").use {
        launch (it){
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }
}

