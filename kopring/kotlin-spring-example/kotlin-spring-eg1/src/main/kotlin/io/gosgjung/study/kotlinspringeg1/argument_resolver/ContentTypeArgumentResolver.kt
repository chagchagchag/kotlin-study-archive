package io.gosgjung.study.kotlinspringeg1.argument_resolver

import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class ContentTypeArgumentResolver : HandlerMethodArgumentResolver{

    /**
     * 호출되는 Controller 에서 우리가 정의한 어노테이션이 있는지를 검사
     * = 즉, 파라미터를 검사해야 할지 여부를 체크
     */
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.getParameterAnnotation(ContentTypeInfo::class.java) != null
                && parameter.parameterType == String::class.java
    }

    /**
     * WebRequest 내에서 Header 에 추가된 'Content-Type' 에 대한 값을 추출하는데 
     * 만약 값이 있다면 해당 헤더에 대한 값을 리턴
     * 만약 값이 없다면 "Content Type is Empty" 라는 문자열을 리턴
     */
    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val req: HttpServletRequest = webRequest.nativeRequest as HttpServletRequest
        return req.getHeader("Content-Type") ?: "Content Type is Empty"
    }

}