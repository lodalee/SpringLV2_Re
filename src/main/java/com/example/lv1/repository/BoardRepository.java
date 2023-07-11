package com.example.lv1.repository;

import com.example.lv1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//왜 하필 Long 타입을?
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();
}
