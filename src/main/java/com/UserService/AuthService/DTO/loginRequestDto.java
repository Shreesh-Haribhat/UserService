package com.UserService.AuthService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginRequestDto {
    private String email;
    private String password;
}
