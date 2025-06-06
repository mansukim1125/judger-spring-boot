package com.mansu.judger.submission;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class SubmissionRepository {
    private final ConcurrentHashMap<UUID, Submission> submissions = new ConcurrentHashMap<>();

    public Submission findOne(UUID id) {
        Submission submission = this.submissions.get(id);
        if (submission == null) return null;
        return new Submission(
            submission.id(),
            submission.problemId(),
            submission.userId(),
            submission.language(),
            submission.code()
        );
    }

    public Stream<Submission> findMany(UUID problemId) {
        return this.submissions
            .values()
            .stream()
            .filter(submission -> submission.problemId() == problemId);
    }

    public void create(Submission submission) {
        this.submissions.put(
            submission.id(),
            new Submission(
                submission.id(),
                submission.problemId(),
                submission.userId(),
                submission.language(),
                submission.code()
            )
        );
    }
}
