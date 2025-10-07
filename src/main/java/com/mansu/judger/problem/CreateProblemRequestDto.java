package com.mansu.judger.problem;

import jakarta.validation.constraints.NotEmpty;

public record CreateProblemRequestDto(
    @NotEmpty String title,
    @NotEmpty String description,
    long cpuTimeLimit,
    long wallTimeLimit, 
    long memoryLimit
) {}
