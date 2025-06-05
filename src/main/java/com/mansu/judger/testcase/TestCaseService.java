package com.mansu.judger.testcase;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mansu.judger.problem.Problem;
import com.mansu.judger.problem.ProblemService;

@Service
public class TestCaseService {
    private TestCaseRepository testCaseRepository;
    private ProblemService problemService;
    
    public TestCaseService(
        TestCaseRepository testCaseRepository,
        ProblemService problemService
    ) {
        this.testCaseRepository = testCaseRepository;
        this.problemService = problemService;
    }

    public ArrayList<TestCase> getTestCasesByProblemId(UUID problemId) {
        Problem problem = this.problemService.getProblem(problemId);

        return new ArrayList<>(
            this.testCaseRepository
                .findMany(problem.id())
                .toList()
        );
    }

    public UUID createTestCase(UUID problemId, String expectedInput, String expectedOutput) {
        Problem problem = this.problemService.getProblem(problemId);
        
        UUID id = UUID.randomUUID();
        this.testCaseRepository.create(
            new TestCase(
                id,
                problem.id(),
                expectedInput,
                expectedOutput
            )
        );

        return id;
    }
}
