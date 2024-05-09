package com.spharos.mongodb.chat.controller;

import com.spharos.mongodb.chat.domain.Chat;
import com.spharos.mongodb.chat.service.ChatService;
import com.spharos.mongodb.chat.vo.ChatVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // Flux는 비동기 방식이므로 produces 처리해줘야 한다.
    @GetMapping(value = "/sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getChat(
        @PathVariable(value = "sender") String sender,
        @PathVariable(value = "receiver")  String receiver) {
        return chatService.getChat(sender, receiver).subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping(value = "/room/{roomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getChatByRoomId(@PathVariable(value = "roomId") String roomId) {
        return chatService.getChatByRoomId(roomId).subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public void sendChat(@RequestBody ChatVo chatVo) {
        chatService.sendChat(chatVo);
    }


}
