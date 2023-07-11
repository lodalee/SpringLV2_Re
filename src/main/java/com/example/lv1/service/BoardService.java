package com.example.lv1.service;

import com.example.lv1.dto.requestDto.BoardRequestDto;
import com.example.lv1.dto.responseDto.BoardResponseDto;
import com.example.lv1.entity.Board;
import com.example.lv1.entity.User;
import com.example.lv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //게시글 생성
    public BoardResponseDto createBoard(BoardRequestDto requestDto, User user){
        Board board = new Board(requestDto, user.getUsername());

        //DB저장
        Board saveBoard = boardRepository.save(board);
        BoardResponseDto boardResponseDto = new BoardResponseDto(saveBoard);

        return boardResponseDto;
    }

    //전체 게시글 조회
    public List<BoardResponseDto> getBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    //선택 게시글 조회
    public BoardResponseDto getBoardById(Long id){
        Board board = findBoard(id);
        return new BoardResponseDto(board);
    }

    //게시글 수정
    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto, User user) {
        Board board = findBoard(id);

        if (!(board.getUsername().equals(user.getUsername()))){
            new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }
//        //username 확인
//        if (!board.getUsername().equals(requestDto.getUsername())){
//            throw new IllegalArgumentException("username 이 일치하지 않습니다.");
//        }
//        //비밀번호 확인
//        if(!board.getPassword().equals(requestDto.getPassword())){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }

        board.update(requestDto);
        return new BoardResponseDto(board);
    }

    //게시글 삭제
    @Transactional
    public void deleteBoard(Long id, User user){
        Board board = findBoard(id);

        if (!(board.getUsername().equals(user.getUsername()))){
            new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
        }
//        //비밀번호 확인
//        if(!board.getPassword().equals(requestDto.getPassword())){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
        boardRepository.delete(board);
    }

    private Board findBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
