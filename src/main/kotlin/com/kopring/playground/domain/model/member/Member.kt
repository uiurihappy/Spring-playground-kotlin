package com.kopring.playground.domain.model.member

import com.kopring.playground.util.generateULID

data class Member(
    val memberId: String,
    val nickname: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
) {
    fun initializeNickname(nickname: String) =
        this.copy(
            nickname = nickname,
        )

    companion object {
        fun createMember(
            nickname: String,
            name: String,
            email: String,
            phoneNumber: String,
            password: String,
        ) = Member(
            memberId = generateULID(),
            nickname = nickname,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
        )
    }
}
