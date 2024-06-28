package com.example.hhhack.service;


import com.example.hhhack.entity.ChatMessage;
import com.example.hhhack.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> findByChatRoomId(Long chatRoomId) {
        return chatMessageRepository.findByChatRoomIdOrderByCreatedAtAsc(chatRoomId);
    }

    public Optional<ChatMessage> findById(Long id) {
        return chatMessageRepository.findById(id);
    }

    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public void deleteById(Long id) {
        chatMessageRepository.deleteById(id);
    }
}