package com.fmt.biblioteca.handlers;

public class RestNotFoundException extends RuntimeException {
    public RestNotFoundException(String message){
        super(message);
    }
}
