package com.UserService.AuthService.Controller;

import com.UserService.AuthService.DTO.UserDto;
import com.UserService.AuthService.DTO.loginRequestDto;
import com.UserService.AuthService.DTO.signUpRequestDto;
import com.UserService.AuthService.Exception.NoSuchUserExistException;
import com.UserService.AuthService.Exception.UserUnauthorizedException;
import com.UserService.AuthService.Model.Token;
import com.UserService.AuthService.Model.User;
import com.UserService.AuthService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public User signUp(@RequestBody signUpRequestDto requestDto)
    {
        return userService.signUp(requestDto.getEmail(),
                requestDto.getPassword(),requestDto.getName());
    }

    @PostMapping("/login")
    public Token login(@RequestBody loginRequestDto requestDto) throws NoSuchUserExistException {
        return userService.login(requestDto.getEmail(),requestDto.getPassword());
    }

    @PostMapping("/logout/{token}")
    public ResponseEntity<Void> logout(@PathVariable("token") String token) throws UserUnauthorizedException {
        userService.logout(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("validateToken/{token}")
    public UserDto validate(@PathVariable("token") String token) throws NoSuchUserExistException {
        User user = userService.validate(token);
        if(user == null)
        {
            throw new NoSuchUserExistException("No such user exist");
        }
        return UserDto.form(userService.validate(token));
    }

}
