package com.UserService.AuthService.DTO;

import com.UserService.AuthService.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class signUpRequestDto {
    private String email;
    private String password;
    private String name;
}
