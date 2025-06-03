package com.mansu.judger.testcase;

public record CreateTestCaseRequestDto(
    String expectedInput,
    String expectedOutput
) {}
