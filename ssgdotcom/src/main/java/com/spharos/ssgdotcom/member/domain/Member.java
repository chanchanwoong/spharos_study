package com.spharos.ssgdotcom.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * setter를 쓰면 엔티티 오염이 될 수 있다.
 * 생성자를 쓰거나 builder를 사용한다. builder가 생성자랑 같은데 가독성을 추가한 것 뿐
 * getter만 사용한다고 한다.
 *
 * 데이터 변경이 안되는 것, VO와 DTO 관련이 있나?
 */
@Entity     // 영속성을 부여, DB에 들어갈 테이블 역할을 한다.
@Getter     // Getter만 있으면 된다.
@NoArgsConstructor      // 기본 생성자
@Table(name = "member_table")     // 테이블 명칭 부여하고 테이블을 생성해준다.
public class Member implements UserDetails {
    @Id     // primary key로 설정
//    @GeneratedValue(strategy = GenerationType.AUTO)     // Auto-increment 해준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // AUTO보단 IDENTITY를 사용한다.
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    @Column(columnDefinition = "TINYINT", length = 1, nullable = true)     // 컬럼의 상세 옵션 선택 가능
    private Short gender;
    @Column(nullable = true)
    private String codeName;

    @Builder
    public Member(String password, String name, String email, String phone, String address, Short gender){
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 반환
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> "Member");
        return collectors;
    }

    @Override
    public String getUsername() {
        return loginId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
