package com.spharos.mongodb.chat.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ChatVo {
    private String msg;
    private String sender;
//    private String receiver;

    private String roomId;
}
