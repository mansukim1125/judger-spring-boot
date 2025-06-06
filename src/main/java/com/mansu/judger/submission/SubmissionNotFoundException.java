package com.mansu.judger.submission;

import org.springframework.http.HttpStatus;

import com.mansu.judger.exception.BaseException;

public class SubmissionNotFoundException extends BaseException {
    public SubmissionNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
