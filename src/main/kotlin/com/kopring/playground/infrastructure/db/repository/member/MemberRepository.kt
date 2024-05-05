package com.kopring.playground.infrastructure.db.repository.member

import com.kopring.playground.infrastructure.db.entity.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<MemberEntity, String> {
    fun findByEmail(email: String): MemberEntity?
}
