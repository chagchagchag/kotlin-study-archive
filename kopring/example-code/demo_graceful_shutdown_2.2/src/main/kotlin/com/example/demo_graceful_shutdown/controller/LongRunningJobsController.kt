package com.example.demo_graceful_shutdown.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LongRunningJobsController {

    @GetMapping("/long-running-job")
    fun getLongRunningJob() : String{
        Thread.sleep(15000)
        return "실행 완료~!!"
    }

}