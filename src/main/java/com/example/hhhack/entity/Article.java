package com.example.hhhack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "body", length = 200)
    private String body;

    @Column(name = "status", nullable = false)
    private String status = "selling";

    @Column(name = "articlePrice")
    private Integer articlePrice;

    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }

    // Getters and Setters
}