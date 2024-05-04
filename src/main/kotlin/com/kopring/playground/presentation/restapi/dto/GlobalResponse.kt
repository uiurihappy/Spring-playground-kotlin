package com.kopring.playground.presentation.restapi.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "전역 응답")
data class GlobalResponse (
    val success: Boolean,
    val status: Int,
    val data: Any?,
    val timestamp: LocalDateTime
) {
    // companion object를 사용하여 success와 fail을 정적 메소드로 정의
    // success는 성공 응답을 생성하고, fail은 실패 응답을 생성
    companion object {
        fun success(status: Int, data: Any?): GlobalResponse {
            return GlobalResponse(true, status, data, LocalDateTime.now())
        }

        fun fail(status: Int, errorResponse: ErrorResponse?): GlobalResponse {
            return GlobalResponse(false, status, errorResponse, LocalDateTime.now())
        }
    }
}
