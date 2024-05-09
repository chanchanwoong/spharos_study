package com.spharos.mongodb.chat.service;

import com.spharos.mongodb.chat.domain.Chat;
import com.spharos.mongodb.chat.repository.ChatRepository;
import com.spharos.mongodb.chat.vo.ChatVo;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    public void sendChat(ChatVo chatVo) {
        chatRepository.save(
            Chat.builder()
                .msg(chatVo.getMsg())
                .sender(chatVo.getSender())
                .roomId(chatVo.getRoomId())
                .createdAt(LocalDateTime.now())
                .build()
        ).subscribe();
    }

    @Override
    public Flux<Chat> getChat(String sender, String receiver) {
        return chatRepository.findChatBySenderAndReceiver(sender, receiver);
    }

    @Override
    public Flux<Chat> getChatByRoomId(String roomId) {
        return null;
    }
}
