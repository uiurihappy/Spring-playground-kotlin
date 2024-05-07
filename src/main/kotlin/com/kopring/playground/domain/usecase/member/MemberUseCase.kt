package com.kopring.playground.domain.usecase.member

import com.kopring.playground.domain.gateway.member.MemberGateway
import com.kopring.playground.domain.model.member.Member
import com.kopring.playground.domain.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class MemberUseCase(
    private val memberGateway: MemberGateway
) : UseCase<MemberUseCase.MemberUseCaseRequest, Member> {
    data class MemberUseCaseRequest(
        val email: String,
        val password: String,
        val nickname: String,
        val name: String,
        val phoneNumber: String
    )

    override fun execute(request: MemberUseCaseRequest): Member {
        val member = Member.createMember(
            nickname = request.nickname,
            name = request.name,
            email = request.email,
            phoneNumber = request.phoneNumber,
            password = request.password
        )
        return memberGateway.save(member)
    }
}
