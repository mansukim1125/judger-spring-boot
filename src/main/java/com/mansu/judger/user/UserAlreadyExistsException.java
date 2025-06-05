package com.mansu.judger.user;

import org.springframework.http.HttpStatus;

import com.mansu.judger.exception.BaseException;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
