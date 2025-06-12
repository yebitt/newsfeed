package com.example.newsfeed.controller;

import com.example.newsfeed.requestDto.post.PostCreateRequestDto;
import com.example.newsfeed.requestDto.post.PostUpdateRequestDto;
import com.example.newsfeed.responseDto.post.PostResponseDto;
import com.example.newsfeed.responseDto.post.PostCreateResponseDto;
import com.example.newsfeed.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    // create
    @PostMapping
    public ResponseEntity<PostCreateResponseDto> createPost(@Validated @RequestBody PostCreateRequestDto request){ // bindingResult에 MethodArgumentNotValidException 담김
        // todo 세션에서 유저아이디 받아오도록 수정하기
        Long userId = 1L;
        // 1. 컨트롤러는 서비스에 넘겨주고 -> 서비스는 '로직 수행과 레파지토리에 저장'을 하고 -> 로직 수행된 dto를 컨트롤러에 반환한다
        PostCreateResponseDto response = service.createService(request, userId);
        // 2. 해당 dto 반환
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // read (전체)
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> readPost(){
        // todo 세션에서 유저아이디 받아오도록 수정하기
        List<PostResponseDto> results = service.readService();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    // read (단건)
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> readOnePost(@PathVariable Long id){
        PostResponseDto result = service.readOneService(id);
        return ResponseEntity.ok(result);
    }

    // read (일부) : 전체 데이터 중 필터링해서 여러 건 가져옴

    // update
    @PatchMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto request){
        PostResponseDto result = service.updateService(id, request);
        return ResponseEntity.ok(result);
    }

    // delete
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        service.deleteService(id);
        return "삭제 완료";
    }

}
