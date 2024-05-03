package com.kopring.playground.presentation.restapi.dto

import com.kopring.playground.domain.exception.ErrorCode
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus

@Schema(description = "에러(오류) 응답")
data class ErrorResponse(
    @Schema(description = "에러 코드", example = "500")
    val code: HttpStatus,
    @Schema(description = "에러 메세지", example = "인가되지 않은 접근입니다.")
    val message: String,
    @Schema(description = "관련 데이터")
    val data: Any? = null,
) {
    companion object {
        fun fromErrorCode(
            errorCode: ErrorCode,
            data: Any? = null,
        ) = with(errorCode) {
            ErrorResponse(
                code = code,
                message = message,
                data = data,
            )
        }
    }
}
