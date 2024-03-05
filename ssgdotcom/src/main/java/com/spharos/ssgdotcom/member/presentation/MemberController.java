package com.spharos.ssgdotcom.member.presentation;

import com.spharos.ssgdotcom.member.application.MemberService;
import com.spharos.ssgdotcom.member.domain.Member;
import com.spharos.ssgdotcom.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController     // Rest 컨트롤러로 사용하겠다 선언
@RequestMapping("/api/v1/member")       // 기본 url 값 지정
public class MemberController {
    private final MemberService memberService;      // 생성자 필요
    public void modifyUserPwd(){

    }

    @PostMapping("/create")
    public Member createMember(@RequestBody MemberDto memberDto) {
        Member member = memberService.createMember(memberDto);
        return member;
    }
}
