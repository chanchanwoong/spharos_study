package com.spharos.ssgdotcom.security;

import com.spharos.ssgdotcom.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration      // 빈 등록
@RequiredArgsConstructor
public class ApplicationConfig {

    private final MemberRepository memberRepository;
    public UserDetailsService memberDetailsService() {
        return loginId -> (UserDetails) memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found : {}" + loginId));
    }
}
