package io.gosgjung.study.kotlinspringeg1.argument_resolver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContentTypeInfoController {

    @GetMapping("/content-type")
    fun getContentTypeInfo(@ContentTypeInfo contentTypeInfo: String) : String{
        return contentTypeInfo
    }

}