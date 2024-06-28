package UMC.spring.study.domain.mapping;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int charRoomId;
    private int senderId;
    private String message;
    private boolean reading;
}
