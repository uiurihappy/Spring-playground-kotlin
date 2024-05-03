package com.kopring.playground.domain.exception

open class DomainException(
    val errorCode: ErrorCode,
    val data: Any? = null,
) : RuntimeException(errorCode.message)
