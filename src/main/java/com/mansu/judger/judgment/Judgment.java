package com.mansu.judger.judgment;

import java.util.ArrayList;
import java.util.UUID;

public class Judgment {
    // 채점 에 어떤 데이터가 필요한가.
    // submission 을 알아야 한다. 제출한 코드/문제 제약 조건/언어/제출 자를 알아야 하기 때문에.
    // 채점 결과를 알아야 한다. 결과를 기록해야 하기 때문에.
    UUID id;
    UUID submissionId;
    JudgmentStatus status;
    ArrayList<TestCaseResult> testcaseResults;
}
