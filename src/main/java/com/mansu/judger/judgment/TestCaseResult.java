package com.mansu.judger.judgment;

import java.util.UUID;

public record TestCaseResult(
    UUID testCaseId,
    ExecutionStatus status,
    long executionCpuTime,
    long executionWallTime,
    long memoryUsage,
    String stdout,
    String stderr
) {}
