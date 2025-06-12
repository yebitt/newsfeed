package com.example.newsfeed.exception;

import org.springframework.http.HttpStatus;

public class UserException extends abstractException {

  public UserException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }

  public UserException(String message) {
    super(message, HttpStatus.BAD_REQUEST);
  }
}
