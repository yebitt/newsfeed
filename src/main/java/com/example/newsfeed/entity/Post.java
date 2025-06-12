package com.example.newsfeed.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    // 단방향 연관 관계
    @ManyToOne
    @JoinColumn(name = "user_id") // FK 설정
    private User user;

    public Post(){}

    public Post(String title, String content, User user){
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
