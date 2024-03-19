package com.fmt.biblioteca.handlers;

public class RestConflictException extends RuntimeException {
    public RestConflictException(String message){
        super(message);
    }
}
