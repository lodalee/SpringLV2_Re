package com.example.lv1.entity;

import com.example.lv1.dto.requestDto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //DB랑 연결 시켜주기 위해서?
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String contents;

//    @Column(nullable = false, length = 100)
//    private String password;



    public Board(BoardRequestDto requestDto, String username) {
        this.username = username;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    //수정은 제목과 작성내용만 진행함
    public void update(BoardRequestDto requestDto) {
//        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
