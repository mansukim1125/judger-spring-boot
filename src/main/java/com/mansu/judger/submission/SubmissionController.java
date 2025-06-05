package com.mansu.judger.submission;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmissionController {
    private SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    /*
     * 답안 제출
     */
    @PostMapping("/submissions")
    public ResponseEntity<CreateSubmissionResponseDto> createSubmission(
        @RequestBody CreateSubmissionRequestDto request
    ) throws URISyntaxException {
        UUID id = this.submissionService.createSubmission(
            request.problemId(),
            request.userId(),
            request.language(),
            request.code()
        );

        return ResponseEntity
            .created(new URI("/submissions/" + id))
            .body(new CreateSubmissionResponseDto(id));
    }

    /*
     * 단일 제출 데이터 조회
     */
    @GetMapping("/submissions/{id}")
    public ResponseEntity<Submission> getSubmissionStatus(
        @PathVariable UUID submissionId
    ) {
        return ResponseEntity
            .ok()
            .body(this.submissionService.getSubmission(submissionId));
    }

    /*
     * 특정 문제에 대한 제출 목록 조회
     */
    @GetMapping("/problems/{problemId}/submissions")
    public ResponseEntity<ArrayList<Submission>> getSubmissionsByProblemId(
        @PathVariable UUID problemId
    ) {
        return ResponseEntity
            .ok()
            .body(this.submissionService.getSubmissionsByProblemId(problemId));
    }
}
