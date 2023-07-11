package com.example.lv1.exception;

import com.example.lv1.dto.responseDto.MessageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalArgumentException(IllegalArgumentException e){
        log.error("IllegalArgumentException", e);
        return new ResponseEntity<>(new MessageResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

