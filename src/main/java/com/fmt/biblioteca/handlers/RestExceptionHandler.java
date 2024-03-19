package com.fmt.biblioteca.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RestNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(RestNotFoundException ex) {
        return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RestConflictException.class)
    protected ResponseEntity<Object> handleEntityInvalid(RestConflictException ex){
        return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}",HttpStatus.CONFLICT);
    }
}
