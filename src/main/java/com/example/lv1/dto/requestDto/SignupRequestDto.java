package com.example.lv1.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
@Getter
public class SignupRequestDto {
    @NotBlank
    @Size(min = 4, max = 10)
    //0~9, 소문자
    @Pattern(regexp =  "^[a-z0-9]+$")
    private String username;

    @NotBlank
    @Size(min = 8, max = 15)
    //대문자, 소문자, 0~9
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String password;
}
