package com.example.newsfeed.service;

import com.example.newsfeed.entity.User;
import com.example.newsfeed.exception.UserException;
import com.example.newsfeed.repository.UserRepository;
import com.example.newsfeed.requestDto.user.UserCreateRequestDto;
import com.example.newsfeed.requestDto.user.UserUpdateRequestDto;
import com.example.newsfeed.responseDto.user.UserCreateResponseDto;
import com.example.newsfeed.responseDto.user.UserResponseDto;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserCreateResponseDto createService(UserCreateRequestDto request){
        User user = new User(request.getName(), request.getEmail(), request.getPassword());
        User savedUser = repository.save(user);
        return new UserCreateResponseDto(savedUser);
    }

    public List<UserResponseDto> readAllService() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(user -> new UserResponseDto(user))
                .collect(Collectors.toList());
    }

    public UserResponseDto readOneService(Long id){
        User user = repository.findById(id).orElseThrow(() -> new UserException("해당 id값의 유저가 없습니다."));
        return new UserResponseDto(user);
    }

    public UserResponseDto updateService(Long id, UserUpdateRequestDto request) {
        User user = repository.findById(id).orElseThrow(() -> new UserException("해당 id값의 유저가 없습니다."));

        user.updateUser(request.getName(), request.getEmail(), request.getPassword());

        User savedUser = repository.save(user);
        return new UserResponseDto(savedUser);
    }

    public void deleteService(Long id) {
        // 삭제할 해당 id값 유저가 있는지 검사
        User user = repository.findById(id).orElseThrow(() -> new UserException("해당 id값의 유저가 없습니다."));

        repository.deleteById(id);
    }
}
