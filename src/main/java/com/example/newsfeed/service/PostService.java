package com.example.newsfeed.service;

import com.example.newsfeed.entity.Post;
import com.example.newsfeed.entity.User;
import com.example.newsfeed.exception.PostException;
import com.example.newsfeed.exception.UserException;
import com.example.newsfeed.repository.PostRepository;
import com.example.newsfeed.repository.UserRepository;
import com.example.newsfeed.requestDto.post.PostCreateRequestDto;
import com.example.newsfeed.requestDto.post.PostUpdateRequestDto;
import com.example.newsfeed.responseDto.post.PostResponseDto;
import com.example.newsfeed.responseDto.post.PostCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final UserRepository userRepository;

    public PostCreateResponseDto createService(PostCreateRequestDto request, Long userId) {
        // 로직
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException("해당 id값의 게시물이 없습니다."));
        // 레파지토리 저장 및 반환
        Post post = new Post(request.getTitle(), request.getContent(), user);
        Post savedPost = repository.save(post);


        return new PostCreateResponseDto(savedPost.getTitle(), savedPost.getContent(), savedPost.getCreatedAt(), savedPost.getUser());
    }

    public List<PostResponseDto> readService() {
        List<Post> posts = repository.findAll();
        List<PostResponseDto> dto = new ArrayList<>();
        for(Post post : posts){
            dto.add(new PostResponseDto(post));
        }
        return dto;
        // 위와 같은 코드
        // return posts.stream().map(post -> new PostListResponseDto(post.getId(), post.getTitle(), post.getContent())).collect(Collectors.toList());
    }

    public PostResponseDto readOneService(Long id) {
        Optional<Post> optionalPost = repository.findById(id);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();
            PostResponseDto dto = new PostResponseDto(post);
            return dto;
        } else {
            throw new PostException("해당 id값의 게시물이 없습니다.");
            // PostException("해당 id값의 게시물이 없습니다.", HttpStatus.OK); => default httpStatus값이 아닌 지정한 200 OK 반환
        }
    }

    public PostResponseDto updateService(Long id, PostUpdateRequestDto request){
        Post post = repository.findById(id).orElseThrow(() -> new PostException("해당 id값의 게시물이 없습니다."));

        if(request.getTitle() != null) {
            post.setTitle(request.getTitle());
        }
        if(request.getContent() != null) {
            post.setContent(request.getContent());
        }

        Post updatePost = repository.save(post);
        PostResponseDto dto = new PostResponseDto(updatePost);
        return dto;
    }

    public void deleteService(Long id) {
        // 삭제할 해당 id값 게시물이 있는지 검사
        Post post = repository.findById(id).orElseThrow(() -> new PostException("해당 id값의 게시물이 없습니다."));

        repository.deleteById(id);
    }
}
