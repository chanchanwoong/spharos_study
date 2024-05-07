package com.spharos.mongodb.chat.vo;

import lombok.Builder;

public class MemberResponse {
    private String id;
    private String name;
    private String email;
    private String phone;

    @Builder
    public MemberResponse(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
