package com.kopring.playground.domain.usecase

fun interface UseCase<I, O> {
    fun execute(input: I): O
}
