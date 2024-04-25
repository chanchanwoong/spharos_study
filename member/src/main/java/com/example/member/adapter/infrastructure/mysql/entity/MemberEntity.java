package com.example.member.adapter.infrastructure.mysql.entity;

import com.example.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String nickName;

    public static MemberEntity fromMember(Member member) {
        return MemberEntity.builder()
                .email(member.getEmail())
                .nickName(member.getNickName())
                .password(member.getPassword())
                .build();
    }
}
