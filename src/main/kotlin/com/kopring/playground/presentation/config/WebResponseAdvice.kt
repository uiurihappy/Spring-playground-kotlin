package com.kopring.playground.presentation.config

import com.kopring.playground.presentation.dto.GlobalResponse
import org.springframework.core.MethodParameter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice(basePackages = ["com.kopring.playground"])
class WebResponseAdvice : ResponseBodyAdvice<Any> {
    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>>,
    ): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse,
    ): Any? {
        val servletResponse =
            (response as ServletServerHttpResponse).servletResponse
        val status = servletResponse.status
        val resolve = HttpStatus.resolve(status)
        if (resolve == null || body is String) {
            return body
        }
        if (resolve.is2xxSuccessful) {
            return GlobalResponse.success(status, body)
        }
        return body
    }
}
