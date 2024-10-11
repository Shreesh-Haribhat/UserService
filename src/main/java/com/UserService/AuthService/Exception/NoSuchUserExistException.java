package com.UserService.AuthService.Exception;

public class NoSuchUserExistException extends Exception{
    public NoSuchUserExistException(String message)
    {
        super(message);
    }
}
