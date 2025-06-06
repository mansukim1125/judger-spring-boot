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
        User user = this.userService.getUser(userId);

        UUID id = UUID.randomUUID();
        this.submissionRepository.create(
            new Submission(
                id,
                problem.id(),
                user.id(),
                language,
                code
            )
        );

        // TODO: call judgment api...

        return id;
    }

    public Submission getSubmission(UUID id) {
        Submission submission = this.submissionRepository.findOne(id);
        if (submission == null) {
            throw new SubmissionNotFoundException("제출이 존재하지 않습니다.");
        }
        return submission;
    }

    public ArrayList<Submission> getSubmissionsByProblemId(UUID problemId) {
        Problem problem = this.problemService.getProblem(problemId);
        return new ArrayList<>(
            this.submissionRepository
                .findMany(problem.id())
                .toList()
        );
    }
}
