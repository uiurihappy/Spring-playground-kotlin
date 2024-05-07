package com.kopring.playground.presentation.api.member

import com.kopring.playground.domain.model.member.Member
import com.kopring.playground.domain.usecase.member.MemberUseCase
import com.kopring.playground.presentation.api.member.dto.CreateNewMemberResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "회원 API", description = "회원 정보를 관리하는 API")
@RestController
@RequestMapping("/members")
class MemberController(
    private val memberUseCase: MemberUseCase
) {
    @PostMapping
    fun createMember(
        @RequestBody @Valid request: MemberUseCase.MemberUseCaseRequest
    ) : CreateNewMemberResponse {
        val member = memberUseCase.execute(
            MemberUseCase.MemberUseCaseRequest(
                email = request.email,
                password = request.password,
                nickname = request.nickname,
                name = request.name,
                phoneNumber = request.phoneNumber
            )
        )
        return CreateNewMemberResponse.fromDomain(member)
    }
}
