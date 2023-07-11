package com.example.lv1.service;

import com.example.lv1.dto.requestDto.LoginRequestDto;
import com.example.lv1.dto.requestDto.SignupRequestDto;
import com.example.lv1.entity.User;
import com.example.lv1.jwt.JwtUtil;
import com.example.lv1.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    //회원 가입 구현
    public void signup(SignupRequestDto requestDto){
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());

        //회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()){
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        //사용자 등록
        User user = new User(username, password);
        userRepository.save(user);
    }

    //로그인 구현
    public void login(LoginRequestDto requestDto, HttpServletResponse res){
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        //사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다."));

        //비밀번호 확인
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        //JWT 생성 및 쿠키에 저장 후 Response 객체에 추가하기
        String token = jwtUtil.createToken(user.getUsername());
        jwtUtil.addJwtToCookie(token, res);
    }
}
