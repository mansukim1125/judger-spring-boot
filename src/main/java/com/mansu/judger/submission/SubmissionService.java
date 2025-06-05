package com.mansu.judger.submission;

import java.util.ArrayList;
import java.util.UUID;

import com.mansu.judger.problem.Problem;
import org.springframework.stereotype.Service;

import com.mansu.judger.language.Language;
import com.mansu.judger.problem.ProblemService;
import com.mansu.judger.user.User;
import com.mansu.judger.user.UserService;

@Service
public class SubmissionService {
    private SubmissionRepository submissionRepository;
    private ProblemService problemService;
    private UserService userService;

    public SubmissionService(
        SubmissionRepository submissionRepository,
        ProblemService problemService,
        UserService userService
    ) {
        this.submissionRepository = submissionRepository;
        this.problemService = problemService;
        this.userService = userService;
    }

    public UUID createSubmission(
        UUID problemId,
        UUID userId,
        Language language,
        String code
    ) {
        Problem problem = this.problemService.getProblem(problemId);
        if (problem == null) {
            // throw 
        }

        User user = this.userService.getUser(userId);
        if (user == null) {
            // throw 
        }

        UUID id = UUID.randomUUID();

        this.submissionRepository.create(
            new Submission(
                id,
                problemId,
                userId,
                language,
                code
            )
        );

        // TODO: call judgment api...

        return id;
    }

    public Submission getSubmission(UUID id) {
        return this.submissionRepository.findOne(id);
    }

    public ArrayList<Submission> getSubmissionsByProblemId(UUID problemId) {
        return new ArrayList<>(
            this.submissionRepository
                .findMany(problemId)
                .toList()
        );
    }
}
