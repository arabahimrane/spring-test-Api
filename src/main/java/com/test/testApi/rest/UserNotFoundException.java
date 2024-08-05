package com.test.testApi.rest;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String name) {
        super("Could not find user " + name);
    }


}
