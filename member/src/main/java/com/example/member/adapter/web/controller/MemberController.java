package com.example.member.adapter.web.controller;

import com.example.member.adapter.web.vo.RequestMember;
import com.example.member.application.port.in.MemberUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;
    private final Environment env;

    @PostMapping
    public void signUpMember(@RequestBody RequestMember requestMember) {
        log.info("port number: {}", env.getProperty("local.server.port"));
        log.info("signUpMember requestMember: {}", requestMember);
        memberUseCase.signUpMember(MemberUseCase.SignUPQuery.toQuery(requestMember));
    }
}