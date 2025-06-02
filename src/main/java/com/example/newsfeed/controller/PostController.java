package com.example.newsfeed.controller;

import com.example.newsfeed.entity.Post;
import com.example.newsfeed.requestDto.PostRequestDto;
import com.example.newsfeed.responseDto.PostResponseDto;
import com.example.newsfeed.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service){
        this.service = service;
    }

    // create
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto request){
        // 1. 컨트롤러는 서비스에 넘겨주고 -> 서비스는 '로직 수행과 레파지토리에 저장'을 하고 -> 로직 수행된 dto를 컨트롤러에 반환한다
        PostResponseDto response = service.createService(request);
        // 2. 해당 dto 반환
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // read

    // update

    // delete

}
