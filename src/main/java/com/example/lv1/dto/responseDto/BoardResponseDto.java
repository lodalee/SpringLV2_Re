package com.example.lv1.dto.responseDto;

import com.example.lv1.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class BoardResponseDto {
    private String username; //작성자명
    private String title; //제목
    private String contents; //작성 내용
    private LocalDateTime createdAt; //작성 시간

    public BoardResponseDto(Board board) {
        this.username = board.getUsername();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
    }
}
