package com.kopring.playground.domain.gateway.member

import com.kopring.playground.domain.model.member.Member

interface MemberGateway {
    fun findByEmail(email: String): Member?

    fun getById(memberId: String): Member

    fun save(member: Member): Member
}
