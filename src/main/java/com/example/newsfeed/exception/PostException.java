package com.example.newsfeed.exception;

import org.springframework.http.HttpStatus;

public class PostException extends abstractException {

    public PostException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public PostException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
