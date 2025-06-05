package com.mansu.judger.problem;

import org.springframework.http.HttpStatus;

import com.mansu.judger.exception.BaseException;

public class ProblemAlreadyExistsException extends BaseException {
    public ProblemAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
