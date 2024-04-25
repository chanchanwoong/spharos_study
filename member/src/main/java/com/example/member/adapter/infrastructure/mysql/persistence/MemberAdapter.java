package com.example.member.adapter.infrastructure.mysql.persistence;

import com.example.member.adapter.infrastructure.mysql.entity.MemberEntity;
import com.example.member.adapter.infrastructure.mysql.repository.MemberRepository;
import com.example.member.application.port.MemberPort;
import com.example.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberAdapter implements MemberPort {

    public final MemberRepository memberRepository;

    @Override
    public void signUpMember(Member member) {
        MemberEntity memberEntity = MemberEntity.fromMember(member);
        memberRepository.save(memberEntity);
    }
}
