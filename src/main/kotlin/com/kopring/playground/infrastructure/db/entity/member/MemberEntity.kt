package com.kopring.playground.infrastructure.db.entity.member

import com.kopring.playground.domain.model.member.Member
import jakarta.persistence.*

@Entity(name = "member")
class MemberEntity private constructor(
    @Id
    @Column(name = "member_id", length = 26, columnDefinition = "CHAR(26)", nullable = false)
    val id: String,
    @Column(name = "nickname", nullable = true)
    val nickname: String?,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "email", nullable = false, unique = true)
    val email: String,
    @Column(name = "phone_number", nullable = true)
    val phoneNumber: String?,
    @Column(name = "password", nullable = false)
    val password: String,
) {
    fun toDomain() =
        Member(
            memberId = id,
            nickname = nickname ?: "",
            name = name,
            email = email,
            phoneNumber = phoneNumber ?: "",
            password = password,
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MemberEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    // companion object를 사용하여 정적 메소드로 정의
    companion object {
        fun fromDomain(member: Member) =
            with(member) {
                MemberEntity(
                    id = memberId,
                    nickname = nickname,
                    name = name,
                    email = email,
                    phoneNumber = phoneNumber,
                    password = password,
                )
            }
    }
}
