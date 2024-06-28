package com.example.hhhack.service;

import com.example.hhhack.entity.ChatRoom;
import com.example.hhhack.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    public List<ChatRoom> findAllByOrderByUpdatedAtDesc() {
        return chatRoomRepository.findAllByOrderByUpdatedAtDesc();
    }

    public Optional<ChatRoom> findById(Long id) {
        return chatRoomRepository.findById(id);
    }

    public ChatRoom save(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public void deleteById(Long id) {
        chatRoomRepository.deleteById(id);
    }
}