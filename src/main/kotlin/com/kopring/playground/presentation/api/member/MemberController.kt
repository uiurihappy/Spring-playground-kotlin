package com.kopring.playground.presentation.api.member

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "회원 API", description = "회원 정보를 관리하는 API")
@RestController
@RequestMapping("/members")
class MemberController(

) {

}
