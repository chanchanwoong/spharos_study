package com.spharos.ssgdotcom.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;

@RequiredArgsConstructor
public class JwtAuthenticationFilter {

    // Todo JwtTokenProvider 추가
    private final UserDetailsService userDetailsService;
    // Todo doFilterInternal 추가
}
