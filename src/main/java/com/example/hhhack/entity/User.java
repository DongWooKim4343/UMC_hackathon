package com.example.hhhack.entity;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint default 1")
    private Long id;

    @Column(nullable = false, length = 20)
    private String password;

    @Column( length = 20)
    private String nickName;

    @Column(length = 10)
    private String gender;

    @Column(length = 30)
    private String email;

    @Column(nullable = true)
    private String status;

    @Column(length = 20)
    private String phone;

    @Column
    private LocalDateTime inactiveDate;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt;

    // username 필드 추가
    @Column(nullable = false, length = 20)
    private String username;
    // Getters and Setters
}