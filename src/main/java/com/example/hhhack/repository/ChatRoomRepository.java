package com.example.hhhack.repository;


import com.example.hhhack.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findAllByOrderByUpdatedAtDesc();
}