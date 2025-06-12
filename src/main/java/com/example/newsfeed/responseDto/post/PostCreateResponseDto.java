package com.example.newsfeed.responseDto.post;

import com.example.newsfeed.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostCreateResponseDto {
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final String userName;

    public PostCreateResponseDto(String title, String content, LocalDateTime createdAt, User user){
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.userName = user.getName();
    }
}
