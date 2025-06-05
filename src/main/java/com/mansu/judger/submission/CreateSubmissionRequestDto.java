package com.mansu.judger.submission;

import java.util.UUID;

import com.mansu.judger.language.Language;

public record CreateSubmissionRequestDto(
    UUID problemId,
    UUID userId,
    Language language,
    String code
) {}
