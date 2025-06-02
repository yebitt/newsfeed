package com.example.newsfeed.responseDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

    public PostResponseDto(String title, String content, LocalDateTime createdAt){
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
