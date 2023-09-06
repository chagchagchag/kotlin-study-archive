package io.gosgjung.study.kotlinspringeg1.argument_resolver

import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class CustomArgumentResolversConfig (
    val contentTypeArgumentResolver: ContentTypeArgumentResolver
) : WebMvcConfigurationSupport(){

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        super.addArgumentResolvers(argumentResolvers)
        argumentResolvers.add(contentTypeArgumentResolver)
    }
}