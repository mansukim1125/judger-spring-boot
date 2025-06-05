package com.mansu.judger.testcase;

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
public class TestCaseController {
    private TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/problems/{problemId}/testcases")
    public ResponseEntity<CreateTestCaseResponseDto> createTestCase(
        @PathVariable("problemId") UUID problemId,
        @RequestBody CreateTestCaseRequestDto request
    ) throws URISyntaxException {
        UUID id = this.testCaseService.createTestCase(
            problemId,
            request.expectedInput(),
            request.expectedOutput()
        );

        return ResponseEntity
            .created(new URI(String.format("/problems/%s/testcases/%s", problemId, id)))
            .body(new CreateTestCaseResponseDto(id));
    }

    @GetMapping("/problems/{problemId}/testcases")
    public ResponseEntity<ArrayList<TestCase>> getTestCasesByProblemId(
        @PathVariable("problemId") UUID problemId
    ) {
        return ResponseEntity
            .ok()
            .body(this.testCaseService.getTestCasesByProblemId(problemId));
    }
}
