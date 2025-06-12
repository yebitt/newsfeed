package com.example.newsfeed.requestDto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PostCreateRequestDto {
    @NotBlank(message = "null/공백은 입력 불가합니다.")
    @Size(min = 4, max = 10, message = "글자 수는 4글자 이상 10글자 이하 입니다.")
    private final String title;
    @NotNull(message = "null은 입력 불가합니다.")
    @Size(max = 9999, message = "최대 글자 수는 9999입니다.")
    private final String content;

    public PostCreateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}