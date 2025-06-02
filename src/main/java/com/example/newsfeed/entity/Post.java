package com.example.newsfeed.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;
    @Column(nullable = false)
    private String content;
    // JPA Auditing - createdAt, updatedAt

    public Post(){}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }
}
