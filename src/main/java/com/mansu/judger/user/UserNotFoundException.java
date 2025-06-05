package com.mansu.judger.user;

import org.springframework.http.HttpStatus;

import com.mansu.judger.exception.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
