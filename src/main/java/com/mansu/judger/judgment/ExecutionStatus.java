package com.mansu.judger.judgment;

public enum ExecutionStatus {
    ACCEPTED("AC", "정답"),
    WRONG_ANSWER("WA", "오답"),
    TIME_LIMIT_EXCEEDED("TLE", "시간 초과"),
    MEMORY_LIMIT_EXCEEDED("MLE", "메모리 초과"),
    RUNTIME_ERROR("RE", "런타임 에러"),
    COMPILATION_ERROR("CE", "컴파일 에러"),
    SYSTEM_ERROR("SE", "시스템 오류"),
    JUDGING("JUDGING", "채점 중"),
    PENDING("PENDING", "대기 중");

    private String code;
    private String description;

    ExecutionStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
