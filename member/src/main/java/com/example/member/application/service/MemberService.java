package com.example.member.application.service;

import com.example.member.application.port.MemberPort;
import com.example.member.application.port.in.MemberUseCase;
import com.example.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private final MemberPort memberPort;

    @Override
    public void signUpMember(SignUPQuery signUPQuery) {
        memberPort.signUpMember(Member.signUp(signUPQuery));
    }
}