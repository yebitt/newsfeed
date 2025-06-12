package com.example.newsfeed.requestDto.post;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PostUpdateRequestDto {
    @Size(min = 4, max = 10, message = "글자 수는 4글자 이상 10글자 이하 입니다.")
    private final String title;
    @Size(max = 9999, message = "최대 글자 수는 9999입니다.")
    private final String content;

    @AssertTrue(message = "제목, 내용 중 하나는 반드시 수정해야 합니다.")
    public boolean assertTrueTitleContent(){
        return (title != null) || (content != null);
    }

    public PostUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
