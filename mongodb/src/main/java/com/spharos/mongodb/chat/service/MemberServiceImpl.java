package com.spharos.mongodb.chat.service;

import com.spharos.mongodb.chat.domain.Member;
import com.spharos.mongodb.chat.repository.MemberRepository;
import com.spharos.mongodb.chat.vo.MemberResponse;
import com.spharos.mongodb.chat.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository chatRepository;


    @Override
    public void registerMember(MemberVo memberVo) {
        chatRepository.save(
            Member.builder()
                .email(memberVo.getEmail())
                .name(memberVo.getName())
                .phone(memberVo.getPhone())
                .build()
        );
    }

    @Override
    public MemberResponse getMember(String email) {
        Member member = chatRepository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Member not found")
        );

        return MemberResponse.builder()
            .id(member.getId())
            .name(member.getName())
            .phone(member.getPhone())
            .email(email)
            .build();
    }
}
