package com.example.newsfeed.responseDto.post;

import com.example.newsfeed.entity.Post;
import com.example.newsfeed.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // 필드들 중 Null이 아닌 필드만 Json에 include 하라
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private final String userName;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();

        this.userName = post.getUser().getName();
    }
}
