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
            throw new ProblemNotFoundException("문제가 존재하지 않습니다.");
        }
        return problem;
    }

    public ArrayList<Problem> getProblems(String title, String description) {
        return new ArrayList<>(this.problemRepository.findMany(title, description).toList());
    }

    public UUID createProblem(String title, String description, int timeLimit, int memoryLimit) {
        UUID id = UUID.randomUUID();

        boolean alreadyExists = this.problemRepository.findOne(id) != null;

        if (alreadyExists) {
            throw new ProblemAlreadyExistsException("ID 가 중복된 문제가 존재합니다.");
        }

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
