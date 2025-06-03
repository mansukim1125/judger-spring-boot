package com.mansu.judger.problem;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ProblemService {
    private ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Problem getProblem(UUID problemId) {
        Problem problem = this.problemRepository.findOne(problemId);
        if (problem == null) {
            // throw new NotFoundException("Problem is not found.");
        }
        return problem;
    }

    public ArrayList<Problem> getProblems(String title, String description) {
        return new ArrayList<>(this.problemRepository.findMany(title, description).toList());
    }

    public UUID createProblem(String title, String description, int timeLimit, int memoryLimit) {
        UUID id = UUID.randomUUID();
        Problem newProblem = new Problem(
            id,
            title,
            description,
            timeLimit,
            memoryLimit
        );

        this.problemRepository.create(newProblem);

        return id;
    }
}
