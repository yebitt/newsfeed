package com.example.newsfeed.controller;

import com.example.newsfeed.requestDto.user.UserCreateRequestDto;
import com.example.newsfeed.requestDto.user.UserUpdateRequestDto;
import com.example.newsfeed.responseDto.user.UserCreateResponseDto;
import com.example.newsfeed.responseDto.user.UserResponseDto;
import com.example.newsfeed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    // create
    @PostMapping
    public ResponseEntity<UserCreateResponseDto> createUser(@Validated @RequestBody UserCreateRequestDto request){
        UserCreateResponseDto response = service.createService(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // read (전체)
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> readAllUser(){
        List<UserResponseDto> response = service.readAllService();
        return ResponseEntity.ok(response);
    }

    // read (단건)
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> readOneUser(@PathVariable Long id){
        UserResponseDto response = service.readOneService(id);
        return ResponseEntity.ok(response);
    }

    // read (일부)

    // update
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto request){
        UserResponseDto response = service.updateService(id, request);
        return ResponseEntity.ok(response);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        service.deleteService(id);
        return ResponseEntity.ok("삭제되었습니다.");
    }
}
