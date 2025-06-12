package com.example.newsfeed.responseDto.user;

import com.example.newsfeed.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserCreateResponseDto {
    private final Long id;

    private final String name;
    private final String email;
    private final LocalDateTime createdAt;

    public UserCreateResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
