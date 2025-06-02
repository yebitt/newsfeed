package com.example.newsfeed.service;

import com.example.newsfeed.entity.Post;
import com.example.newsfeed.repository.PostRepository;
import com.example.newsfeed.requestDto.PostRequestDto;
import com.example.newsfeed.responseDto.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository){
        this.repository = repository;
    }

    public PostResponseDto createService(PostRequestDto request){
        // 로직

        // 레파지토리 저장 및 반환
        Post post = new Post(request.getTitle(), request.getContent());
        Post savedPost = repository.save(post);
        return new PostResponseDto(savedPost.getTitle(), savedPost.getContent(), savedPost.getCreatedAt());
    }
}
