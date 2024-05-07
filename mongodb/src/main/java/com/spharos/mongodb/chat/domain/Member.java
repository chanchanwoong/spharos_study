package com.spharos.mongodb.chat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@NoArgsConstructor
@Document(collection = "member")
public class Member {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String phone;

    @Builder
    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
