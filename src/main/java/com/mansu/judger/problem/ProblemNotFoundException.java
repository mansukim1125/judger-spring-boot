package com.mansu.judger.problem;

import org.springframework.http.HttpStatus;

import com.mansu.judger.exception.BaseException;

public class ProblemNotFoundException extends BaseException {
    public ProblemNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
