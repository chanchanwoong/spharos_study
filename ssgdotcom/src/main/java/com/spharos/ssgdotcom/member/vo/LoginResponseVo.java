package com.spharos.ssgdotcom.member.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseVo {
    private String token;
    private String name;
    private String email;
    private String uuid;
}