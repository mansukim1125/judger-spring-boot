package com.mansu.judger.testcase;

import jakarta.validation.constraints.NotEmpty;

public record CreateTestCaseRequestDto(
    @NotEmpty String expectedInput,
    @NotEmpty String expectedOutput
) {}
