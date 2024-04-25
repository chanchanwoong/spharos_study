package com.example.member.adapter.web.controller;

import com.example.member.adapter.web.vo.RequestMember;
import com.example.member.application.port.in.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member-service/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping
    public void signUpMember(@RequestBody RequestMember requestMember) {
//        memberUseCase.signUpMember(memberUseCase.toQuery(requestMember));
    }
}
