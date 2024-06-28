package com.example.hhhack.controller;

import com.example.hhhack.entity.ChatRoom;
import com.example.hhhack.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    // 채팅방 목록 가져오기 (최신순)
    @GetMapping("/messages_list")
    public List<ChatRoom> getChatRoomsByLatest() {
        return chatRoomService.findAllByOrderByUpdatedAtDesc();
    }

    // 특정 채팅방 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Long id) {
        Optional<ChatRoom> chatRoom = chatRoomService.findById(id);
        return chatRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 채팅방 생성
    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomService.save(chatRoom);
    }

    // 채팅방 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<ChatRoom> updateChatRoom(@PathVariable Long id, @RequestBody ChatRoom chatRoomDetails) {
        Optional<ChatRoom> chatRoom = chatRoomService.findById(id);
        if (chatRoom.isPresent()) {
            ChatRoom updatedChatRoom = chatRoom.get();
            updatedChatRoom.setArticle(chatRoomDetails.getArticle());
            chatRoomService.save(updatedChatRoom);
            return ResponseEntity.ok(updatedChatRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 채팅방 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long id) {
        Optional<ChatRoom> chatRoom = chatRoomService.findById(id);
        if (chatRoom.isPresent()) {
            chatRoomService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 채팅 메시지 전송 (재화 내역 남기기)
    @PostMapping("/send")
    public ResponseEntity<Void> sendChat(@RequestParam Long chatRoomId, @RequestParam String message, @RequestParam Long recipientId, @RequestParam Integer amount) {
        Optional<ChatRoom> chatRoom = chatRoomService.findById(chatRoomId);
        if (chatRoom.isPresent()) {
            // 여기에서 거래 내역을 저장하거나 다른 필요한 작업을 수행합니다.
            // 예시 코드: 거래 내역 저장 서비스 호출
            // transactionService.saveTransaction(chatRoomId, recipientId, amount, message);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

//GET /chat/messages_list - 최신순으로 채팅방 목록 가져오기
//GET /chat/{id} - 특정 채팅방 가져오기
//POST /chat - 채팅방 생성
//PUT /chat/{id} - 채팅방 업데이트
//DELETE /chat/{id} - 채팅방 삭제
//POST /chat/send - 채팅 메시지 전송 시 재화 내역 남기기