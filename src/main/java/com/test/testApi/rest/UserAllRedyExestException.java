package com.test.testApi.rest;

public class UserAllRedyExestException extends RuntimeException{
    public UserAllRedyExestException(String name) {
        super("User " + name + " already exists");
    }

}
