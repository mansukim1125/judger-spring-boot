package com.mansu.judger.problem;

public record CreateProblemRequestDto(String title, String description, int timeLimit, int memoryLimit) {}
