package com.example.member.domain;

import com.example.member.application.port.in.MemberUseCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String nickname;

    public static Member signUp(MemberUseCase.SignUpQuery signUpQuery) {
        return Member.builder()
                .name(signUpQuery.getName())
                .email(signUpQuery.getEmail())
                .password(signUpQuery.getPassword())
                .nickname(signUpQuery.getNickname())
                .build();
    }
}
