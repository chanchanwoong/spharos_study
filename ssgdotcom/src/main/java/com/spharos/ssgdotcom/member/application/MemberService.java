package com.spharos.ssgdotcom.member.application;

import com.spharos.ssgdotcom.member.domain.Member;
import com.spharos.ssgdotcom.member.dto.MemberDto;
import com.spharos.ssgdotcom.member.dto.ModifyPasswordDto;

public interface MemberService {
    void modifyUserPwd(ModifyPasswordDto modifyPasswordDto, Object userId);
    Member createMember(MemberDto memberDto);
    Member getMember(Long id);
}
