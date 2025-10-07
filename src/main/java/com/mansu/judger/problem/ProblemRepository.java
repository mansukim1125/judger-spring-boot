package com.mansu.judger.problem;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class ProblemRepository {
    private ConcurrentHashMap<UUID, Problem> problems = new ConcurrentHashMap<>();

    public Problem findOne(final UUID id) {
        Problem problem = this.problems.get(id);
        if (problem == null) return null;

        return new Problem(
            problem.id(),
            problem.title(),
            problem.description(),
            problem.cpuTimeLimit(),
            problem.wallTimeLimit(),
            problem.memoryLimit()
        );
    }

    public Stream<Problem> findMany(String title, String description) {
        return this.problems
            .values()
            .stream()
            .filter(problem -> {
                return problem.title().contains(title) || problem.description().contains(description);
            })
            .map(problem -> {
                return new Problem(
                    problem.id(),
                    problem.title(),
                    problem.description(),
                    problem.cpuTimeLimit(),
                    problem.wallTimeLimit(),
                    problem.memoryLimit()
                );
            });
    }

    public void create(Problem problem) {
        this.problems.put(
            problem.id(),
            new Problem(
                problem.id(),
                problem.title(),
                problem.description(),
                problem.cpuTimeLimit(),
                problem.wallTimeLimit(),
                problem.memoryLimit()
            )
        );
    }
}
