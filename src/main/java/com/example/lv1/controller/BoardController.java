package com.example.lv1.controller;

import com.example.lv1.dto.requestDto.BoardRequestDto;
import com.example.lv1.dto.responseDto.BoardResponseDto;
import com.example.lv1.dto.responseDto.MessageResponseDto;
import com.example.lv1.entity.User;
import com.example.lv1.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    //게시글 생성
    @PostMapping("")
    public BoardResponseDto creatBoard(@RequestBody BoardRequestDto requestDto, HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        return boardService.createBoard(requestDto, user);
    }

    //게시글 전체 조회
    @GetMapping("")
    public List<BoardResponseDto> getBoard(){
        return boardService.getBoard();
    }

    //게시글 선택 조회
    @GetMapping("/{id}")
    public BoardResponseDto getBoardById(@PathVariable Long id){
        return boardService.getBoardById(id);
    }

    //게시글 수정
    @PutMapping("/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id,
                                        @RequestBody BoardRequestDto requestDto,
                                        HttpServletRequest request){
       User user = (User) request.getAttribute("user");
       boardService.updateBoard(id, requestDto, user);

       return new MessageResponseDto("게시글 수정 성공");
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public MessageResponseDto deleteBoard(@PathVariable Long id,
                                          HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        boardService.deleteBoard(id, user);
        
        return new MessageResponseDto("게시글 삭제 성공");
    }
}
