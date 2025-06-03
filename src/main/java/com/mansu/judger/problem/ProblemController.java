package com.mansu.judger.problem;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ArrayList<Problem>> getProblems(@RequestParam Map<String, String> requestMap) {
        return ResponseEntity
            .ok()
            .body(this.problemService.getProblems(
                requestMap.get("title"),
                requestMap.get("description")
            ));
    }

    @PostMapping("/problems")
    public ResponseEntity<CreateProblemResponseDto> createProblem(
        @RequestBody CreateProblemRequestDto request
    ) throws URISyntaxException {
        UUID id = this.problemService.createProblem(
            request.title(),
            request.description(),
            request.timeLimit(),
            request.memoryLimit()
        );
        return ResponseEntity
            .created(new URI("/problems" + id))
            .body(new CreateProblemResponseDto(id));
    }
}
