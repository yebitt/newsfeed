package com.example.newsfeed.requestDto.user;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    private final String name;
    private final String email;
    private final String password;

    @AssertTrue(message = "반드시 하나는 수정해야 합니다.")
    public boolean assertTrueUpdate(){
        return (name != null) || (email != null) || (password != null);
    }

    public UserUpdateRequestDto(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
