package io.gosgjung.study.fpstudy.coroutines.saechawon

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutinesTest3 {

    @Test
    fun test1(){
        runBlocking {
            val job = launch {
                repeat(1000){i->
                    println("job: I'm sleeping $i")
                    delay(500L)
                }
            }

            delay(1300L)
            println("main: I'm tired of waiting!")
            job.cancel()
            job.join()
            println("main: Now I can quit.")
        }
    }

}