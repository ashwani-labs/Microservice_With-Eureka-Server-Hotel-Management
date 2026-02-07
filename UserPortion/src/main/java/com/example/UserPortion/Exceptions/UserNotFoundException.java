package com.example.UserPortion.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Resource Not Found on Server....");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
