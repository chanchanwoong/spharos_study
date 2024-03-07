package com.spharos.ssgdotcom.security;

import com.spharos.ssgdotcom.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration      // 빈 등록
@RequiredArgsConstructor
public class ApplicationConfig {

    private final MemberRepository memberRepository;
    public UserDetailsService memberDetailsService() {
        return loginId -> (UserDetails) memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found : {}" + loginId));
    }

    @Bean
    // 그대로 가져와서 사용하는 메서드
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(memberDetailsService());

        // 비밀번호 암호화 작업
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    // 기본 인증 관리자를 가져와 처리한다.
    // 그대로 가져와서 사용하는 메서드
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    // 비밀번호 암호화하는 메서드
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
