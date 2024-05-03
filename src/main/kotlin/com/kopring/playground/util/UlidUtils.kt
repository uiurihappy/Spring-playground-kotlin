package com.kopring.playground.util

import com.github.f4b6a3.ulid.UlidCreator

fun generateULID() = UlidCreator.getMonotonicUlid().toString()
