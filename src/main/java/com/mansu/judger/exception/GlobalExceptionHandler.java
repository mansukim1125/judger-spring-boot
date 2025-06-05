package com.mansu.judger.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(BaseException e) {
        return ResponseEntity
            .status(e.getHttpStatus())
            .body(
                new ExceptionResponseDto(
                    e.getMessage(),
                    e.getHttpStatus()
                )
            );
    }
}
