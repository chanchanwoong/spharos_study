package com.spharos.ssgdotcom.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder        // Builder를 사용할려면 NoArgsConstructor, AllArgsConstructor 어노테이션을 써야한다는 단점이 있다.
@Data       // 롬복에 대부분 getter, setter 등이 대부분 포함되어 있는 어노테이션
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
}
