package com.kopring.playground.presentation.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI =
        OpenAPI()
            .components(Components())
            .servers(
                listOf(
                    Server().apply {
                        url = "http://localhost:8080"
                        description = "API 서버 Swagger UI"
                    },
                ),
            )
}
