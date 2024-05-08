package com.spharos.mongodb.chat.controller;

import com.spharos.mongodb.chat.service.MemberService;
import com.spharos.mongodb.chat.vo.MemberResponse;
import com.spharos.mongodb.chat.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService chatService;

    @PostMapping
    public void createMember(@RequestBody MemberVo memberVo) {
        log.info("memberVo = {}", memberVo);
        chatService.registerMember(memberVo);
    }

    @GetMapping("/{email}")
    public MemberResponse getMember(@PathVariable String email) {
        return chatService.getMember(email);
    }
}
