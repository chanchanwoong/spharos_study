package com.spharos.ssgdotcom.member.application;

import com.spharos.ssgdotcom.member.domain.Member;
import com.spharos.ssgdotcom.member.dto.MemberDto;
import com.spharos.ssgdotcom.member.dto.ModifyPasswordDto;
import com.spharos.ssgdotcom.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImp implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void modifyUserPwd(ModifyPasswordDto modifyPasswordDto, Object userId) {

    }

    @Override
    public Member createMember(MemberDto memberDto) {
        Member member = Member.builder()
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .phone(memberDto.getPhone())
                .address(memberDto.getAddress())
                .build();

        return memberRepository.save(member);
    }
}
