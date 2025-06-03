package com.mansu.judger.testcase;

import java.util.UUID;

public record TestCase(UUID id, UUID problemId, String expectedInput, String expectedOutput) {}
