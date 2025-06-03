package com.mansu.judger.testcase;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TestCaseService {
    private TestCaseRepository testCaseRepository;
    
    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    public ArrayList<TestCase> getTestCasesByProblemId(UUID problemId) {
        return new ArrayList<>(this.testCaseRepository.findMany(problemId).toList());
    }

    public UUID createTestCase(UUID problemId, String expectedInput, String expectedOutput) {
        UUID id = UUID.randomUUID();
        this.testCaseRepository.create(
            new TestCase(
                id,
                problemId,
                expectedInput,
                expectedOutput
            )
        );

        return id;
    }
}
