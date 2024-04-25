package com.example.member.application.port.in;

import com.example.member.adapter.web.vo.RequestMember;
import com.example.member.application.port.out.dto.MemberDto;
import lombok.Builder;
import lombok.Getter;

public interface MemberUseCase {


    void signUpMember(SignUPQuery signUPQuery);

    @Getter
    @Builder
    class SignUPQuery {

        private String name;
        private String email;
        private String password;
        private String nickName;

        public static SignUPQuery toQuery(RequestMember requestMember) {
            return SignUPQuery.builder()
                    .name(requestMember.getName())
                    .email(requestMember.getEmail())
                    .password(requestMember.getPassword())
                    .nickName(requestMember.getNickName())
                    .build();
        }

    }
}