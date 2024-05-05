package com.kopring.playground.infrastructure.gateway.member

import com.kopring.playground.domain.gateway.member.MemberGateway
import com.kopring.playground.domain.model.member.Member
import com.kopring.playground.infrastructure.db.entity.member.MemberEntity
import com.kopring.playground.infrastructure.db.repository.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberGatewayImpl(
    private val memberRepository: MemberRepository,
) : MemberGateway {
    override fun findByEmail(email: String): Member? {
        return memberRepository.findByEmail(email)?.toDomain()
    }

    override fun getById(memberId: String): Member {
        return memberRepository.getReferenceById(memberId).toDomain()
    }

    override fun save(member: Member): Member {
        val memberEntity = MemberEntity.fromDomain(member)
        return memberRepository.save(memberEntity).toDomain()
    }
}
