package com.example.newsfeed.requestDto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserCreateRequestDto {
    @NotBlank(message = "이름은 필수 입력입니다.")
    private final String name;
    @NotBlank(message = "이메일은 필수 입력입니다.")
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    private final String email;
    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    private final String password;

    public UserCreateRequestDto(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
