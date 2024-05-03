package com.kopring.playground.domain.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val code: HttpStatus,
    val message: String,
) {
    /**
     * 기본 오류
     * @see com.depromeet.makers.domain.exception.DefaultException
     */
    UNKNOWN_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류가 발생했습니다"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인가되지 않은 접근입니다"),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "입력값(바디 혹은 파라미터)가 누락되었습니다"),
}
