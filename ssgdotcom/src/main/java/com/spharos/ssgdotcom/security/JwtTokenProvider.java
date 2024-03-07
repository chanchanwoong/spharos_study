package com.spharos.ssgdotcom.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Slf4j
// token 생성을 위한 클래스
@Service
public class JwtTokenProvider {

    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.token.access-expiration-time}")
    private long accessExpirationTIme;
    @Value("${jwt.token.refresh-expiration-time}")
    private long refreshExpirationTIme;

    /**
     * 1. 토큰에서 loginId 가져오기
     * 2. Claims에서 원하는 claim 값 추출
     * 3. 토큰에서 모든 claims 추출
     * 4. 토큰 key 디코드
     * 5. 토큰 생성
     * 6. 토큰 유효성 검사
     * 7. 토큰 만료 여부 검사
     */

    public String getMemberLoginId(String token) {
        String loginId = extractClaim(token, Claims::getSubject);
        return loginId;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // key를 풀어내는 메서드
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // token 생성 메서드
    public String generateToken(UserDetails userDetails) {
        return generateToken(Map.of(), userDetails);
    }

    public String generateToken(Map<String, Objects> extractClaim, UserDetails userDetails) {
        return buildToken(extractClaim, userDetails, accessExpirationTIme);
    }

    public String buildToken(Map<String, Objects> extractClaim, UserDetails userDetails, long expirationTime) {
        return Jwts.builder()
                .setClaims(extractClaim)
                .claim("role", "MEMBER")
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSigningKey())
                .compact();
    }

    // todo refresh token generate 메서드

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Token Expired");
            return false;
            // todo exception handling
        } catch (MalformedJwtException | IllegalArgumentException e) {
            log.error("Token Invalid");
            return false;
        }
    }
}
