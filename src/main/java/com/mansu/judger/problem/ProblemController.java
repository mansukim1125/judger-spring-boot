package com.mansu.judger.problem;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {
    private ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/problems/{id}")
    public ResponseEntity<Problem> getProblem(@PathVariable("id") UUID id) {
        return ResponseEntity
            .ok()
            .body(this.problemService.getProblem(id));
    }

    @GetMapping("/problems")
    public ResponseEntity<ArrayList<Problem>> getProblems(
        @ModelAttribute GetProblemsRequestDto request
    ) {
        return ResponseEntity
            .ok()
            .body(
                this.problemService.getProblems(
                    request.title(),
                    request.description()
                )
            );
    }

    @PostMapping("/problems")
    public ResponseEntity<CreateProblemResponseDto> createProblem(
        @RequestBody CreateProblemRequestDto request
    ) throws URISyntaxException {
        UUID id = this.problemService.createProblem(
            request.title(),
            request.description(),
            request.cpuTimeLimit(),
            request.wallTimeLimit(),
            request.memoryLimit()
        );
        return ResponseEntity
            .created(new URI("/problems" + id))
            .body(new CreateProblemResponseDto(id));
    }
}
