package io.gosgjung.study.kotlincoroutine.sachawon.ch06

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main() {
    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

    newSingleThreadContext("ctx1").use{ ctx1 ->
        val aa = 1
        newSingleThreadContext("ctx2").use{ ctx2 ->
            val bb = 2
            runBlocking (ctx1) {
                log("ctx1 에서 실행했습니다. aa = ${aa}")

                withContext(ctx2) {
                    log("ctx2 에서 실행중이지요. bb = ${bb}")
                }

                log("다시 ctx1 로 돌아왔어요. aa = ${aa}")
            }
        }
    }
}