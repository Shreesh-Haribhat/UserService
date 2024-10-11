package com.UserService.AuthService.Exception;

public class UserUnauthorizedException extends Exception{

    public UserUnauthorizedException(String msg)
    {
        super(msg);
    }
}
