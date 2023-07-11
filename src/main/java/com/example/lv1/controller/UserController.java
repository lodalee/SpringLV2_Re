package com.example.lv1.controller;

import com.example.lv1.dto.requestDto.LoginRequestDto;
import com.example.lv1.dto.responseDto.MessageResponseDto;
import com.example.lv1.dto.requestDto.SignupRequestDto;
import com.example.lv1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public MessageResponseDto signup(@RequestBody @Valid SignupRequestDto requestDto){
        userService.signup(requestDto);

        return new MessageResponseDto("회원가입 성공");
    }

    //로그인 구현
    @PostMapping("/login")
    public MessageResponseDto login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res){
        userService.login(requestDto, res);

        return new MessageResponseDto("로그인 성공");
    }
}
