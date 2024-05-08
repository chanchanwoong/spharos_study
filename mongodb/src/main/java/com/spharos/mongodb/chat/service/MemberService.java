package com.spharos.mongodb.chat.service;

import com.spharos.mongodb.chat.vo.MemberResponse;
import com.spharos.mongodb.chat.vo.MemberVo;

public interface MemberService {
    void registerMember(MemberVo memberVo);
    MemberResponse getMember(String email);
}
