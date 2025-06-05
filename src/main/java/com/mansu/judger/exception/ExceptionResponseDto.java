package com.mansu.judger.exception;

import org.springframework.http.HttpStatus;

public record ExceptionResponseDto(
    String message,
    HttpStatus statusCode
) {}
