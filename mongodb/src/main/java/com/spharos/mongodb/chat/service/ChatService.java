package com.spharos.mongodb.chat.service;

import com.spharos.mongodb.chat.domain.Chat;
import com.spharos.mongodb.chat.vo.ChatVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChatService {
    void sendChat(ChatVo chatVo);
    Flux<Chat> getChat(String sender, String receiver);

    Flux<Chat> getChatByRoomId(String roomId);
}
