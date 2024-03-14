package com.spharos.ssgdotcom.member.application;

import com.spharos.ssgdotcom.member.vo.LogInRequestVo;
import com.spharos.ssgdotcom.member.vo.LoginResponseVo;
import com.spharos.ssgdotcom.member.vo.SignUpRequestVo;

public interface AuthService {
    void signUp(SignUpRequestVo signUpRequestVo);
    LoginResponseVo logIn(LogInRequestVo logInRequestVo);
}
