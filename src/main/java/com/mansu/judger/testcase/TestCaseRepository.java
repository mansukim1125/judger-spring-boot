package com.mansu.judger.testcase;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class TestCaseRepository {
    private final ConcurrentHashMap<UUID, TestCase> testCases = new ConcurrentHashMap<>();

    public TestCase findOne(UUID id) {
        TestCase testcase = this.testCases.get(id);
        return new TestCase(
            testcase.id(),
            testcase.problemId(),
            testcase.expectedInput(),
            testcase.expectedOutput()
        );
    }

    public Stream<TestCase> findMany(UUID problemId) {
        return this.testCases
            .values()
            .stream()
            .filter(testCase -> testCase.problemId() == problemId)
            .map(testCase -> {
                return new TestCase(
                    testCase.id(),
                    testCase.problemId(),
                    testCase.expectedInput(),
                    testCase.expectedOutput()
                );
            });
    }

    public void create(TestCase testCase) {
        TestCase newTestCase = new TestCase(testCase.id(), testCase.problemId(), testCase.expectedInput(), testCase.expectedOutput());
        this.testCases.put(newTestCase.id(), newTestCase);
    }

    public void delete(UUID id) {
        this.testCases.remove(id);
    }
}
