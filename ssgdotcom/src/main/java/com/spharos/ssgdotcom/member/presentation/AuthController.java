package com.spharos.ssgdotcom.member.presentation;

import com.spharos.ssgdotcom.common.response.BaseResponse;
import com.spharos.ssgdotcom.member.application.AuthService;
import com.spharos.ssgdotcom.member.domain.Member;
import com.spharos.ssgdotcom.member.vo.LogInRequestVo;
import com.spharos.ssgdotcom.member.vo.LoginResponseVo;
import com.spharos.ssgdotcom.member.vo.SignUpRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping()
    public BaseResponse<?> signUp(@RequestBody SignUpRequestVo signUpRequestVo) {
        log.info("signUpRequestVo: {}", signUpRequestVo);
        authService.signUp(signUpRequestVo);
        return new BaseResponse<>();
    }

    @PostMapping("/login")
    public BaseResponse<LoginResponseVo> logIn(@RequestBody LogInRequestVo logInRequestVo) {
        log.info("logIn");
        return new BaseResponse<>(authService.logIn(logInRequestVo));
    }
}