package com.mansu.judger.judgment;

public enum JudgmentStatus {
    PASS("PASS", "통과"),
    FAIL("FAIL", "실패");

    private String code;
    private String description;

    JudgmentStatus(String code, String description) {
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
