package com.kopring.playground.presentation.api.member.dto

import com.kopring.playground.domain.model.member.Member
import io.swagger.v3.oas.annotations.media.Schema


@Schema(description = "사용자 생성 응답 DTO")
data class CreateNewMemberResponse(
    @Schema(description = "사용자 ID")
    val memberId: String,
    @Schema(description = "사용자 닉네임")
    val nickname: String,
    @Schema(description = "사용자 이름")
    val name: String,
    @Schema(description = "사용자 이메일")
    val email: String,
    @Schema(description = "사용자 전화번호")
    val phoneNumber: String,
) {
    companion object {
        fun fromDomain(member: Member) = with(member) {
            CreateNewMemberResponse(
                memberId = memberId,
                nickname = nickname,
                name = name,
                email = email,
                phoneNumber = phoneNumber,
            )
        }
    }
}
