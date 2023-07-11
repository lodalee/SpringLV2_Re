package com.example.lv1.dto.responseDto;

import lombok.Getter;
@Getter
public class MessageResponseDto {
    private String msg;

    public MessageResponseDto(String msg) {
        this.msg = msg;
    }
}
