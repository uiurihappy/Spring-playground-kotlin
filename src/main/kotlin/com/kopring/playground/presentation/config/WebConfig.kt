package com.kopring.playground.presentation.config

import com.kopring.playground.presentation.config.interceptor.WebRequestLogger
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(
    private val webRequestLogger: WebRequestLogger,
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(webRequestLogger)
    }
}
