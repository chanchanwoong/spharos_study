package com.spharos.mongodb.chat.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Getter
@Document(collection = "chat")
public class Chat {

    @Id
    private String Id;
    private String msg;
    private String sender;
    private String receiver;
    private LocalDateTime createdAt;

    @Builder
    public Chat(String msg, String sender, String receiver, LocalDateTime createdAt) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
        this.createdAt = createdAt;
    }

}
