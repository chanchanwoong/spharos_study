package com.example.member.application.port.out.dto;

import com.example.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberDto {
    private String name;
    private String email;
    private String password;
    private String nickname;

//    public MemberDto(Member member) {
//        return MemberDto.builder()
//                .signUp(member.getSignUp())
//                .build();
//    }
}
