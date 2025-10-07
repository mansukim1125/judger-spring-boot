package com.mansu.judger.problem;

import java.util.UUID;

public record Problem(
    UUID id,
    UUID userId,
    String title,
    String description,
    long cpuTimeLimit,
    long wallTimeLimit,
    long memoryLimit
) {}
