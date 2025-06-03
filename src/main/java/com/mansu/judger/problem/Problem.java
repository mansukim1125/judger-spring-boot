package com.mansu.judger.problem;

import java.util.UUID;

public record Problem(UUID id, String title, String description, int timeLimit, int memoryLimit) {}
