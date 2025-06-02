package com.example.newsfeed.requestDto;

import com.example.newsfeed.repository.PostRepository;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private final String title;
    private final String content;

    public PostRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
