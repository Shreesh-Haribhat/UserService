package com.UserService.AuthService.ControllerAdvice;

import com.UserService.AuthService.Exception.NoSuchUserExistException;
import com.UserService.AuthService.Exception.UserUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchUserExistException.class)
    public ResponseEntity<String> handleUnauthorizedException(){
        return new ResponseEntity("No such user found", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserUnauthorizedException.class)
    public ResponseEntity<String> handleUserUnauthorixedException()
    {
        return new ResponseEntity<>("User is Unauthorized",HttpStatus.UNAUTHORIZED);
    }
}
