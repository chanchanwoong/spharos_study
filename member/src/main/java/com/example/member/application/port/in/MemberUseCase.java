package com.example.member.application.port.in;

import com.example.member.adapter.web.vo.RequestMember;
import com.example.member.application.port.out.dto.MemberDto;
import lombok.Builder;
import lombok.Getter;

public interface MemberUseCase {

    void signUpMember(SignUpQuery signUpQuery);

    @Getter
    @Builder
    class SignUpQuery {
        private String name;
        private String email;
        private String password;
        private String nickname;

        public static SignUpQuery toQuery(RequestMember requestMember) {
            return SignUpQuery.builder()
                    .name(requestMember.getName())
                    .email(requestMember.getEmail())
                    .password(requestMember.getPassword())
                    .nickname(requestMember.getNickname())
                    .build();
        }
    }
}
