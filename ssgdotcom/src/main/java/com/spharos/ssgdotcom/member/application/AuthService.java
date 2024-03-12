package com.spharos.ssgdotcom.member.application;

import com.spharos.ssgdotcom.member.vo.LogInRequestVo;
import com.spharos.ssgdotcom.member.vo.SignUpRequestVo;

public interface AuthService {
    void signUp(SignUpRequestVo signUpRequestVo);
    void logIn(LogInRequestVo logInRequestVo);
}
