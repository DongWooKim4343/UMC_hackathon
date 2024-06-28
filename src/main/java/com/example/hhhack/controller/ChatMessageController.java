package com.example.hhhack.controller;

import com.example.hhhack.entity.ChatMessage;
import com.example.hhhack.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    // 특정 채팅방의 메시지 목록 가져오기
    @GetMapping("/{chatRoomId}")
    public List<ChatMessage> getMessagesByChatRoomId(@PathVariable Long chatRoomId) {
        return chatMessageService.findByChatRoomId(chatRoomId);
    }

    // 특정 메시지 가져오기
    @GetMapping("/message/{id}")
    public ResponseEntity<ChatMessage> getMessageById(@PathVariable Long id) {
        Optional<ChatMessage> chatMessage = chatMessageService.findById(id);
        return chatMessage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 메시지 생성
    @PostMapping
    public ChatMessage createMessage(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.save(chatMessage);
    }

    // 메시지 업데이트
    @PutMapping("/message/{id}")
    public ResponseEntity<ChatMessage> updateMessage(@PathVariable Long id, @RequestBody ChatMessage messageDetails) {
        Optional<ChatMessage> chatMessage = chatMessageService.findById(id);
        if (chatMessage.isPresent()) {
            ChatMessage updatedMessage = chatMessage.get();
            updatedMessage.setMessage(messageDetails.getMessage());
            updatedMessage.setReading(messageDetails.isReading());
            chatMessageService.save(updatedMessage);
            return ResponseEntity.ok(updatedMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 메시지 삭제
    @DeleteMapping("/message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        Optional<ChatMessage> chatMessage = chatMessageService.findById(id);
        if (chatMessage.isPresent()) {
            chatMessageService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

//GET /chat/messages/{chatRoomId} - 특정 채팅방의 메시지 목록 가져오기
//GET /chat/messages/message/{id} - 특정 메시지 가져오기
//POST /chat/messages - 메시지 생성
//PUT /chat/messages/message/{id} - 메시지 업데이트
//DELETE /chat/messages/message/{id} - 메시지 삭제