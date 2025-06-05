package com.mansu.judger.submission;

import java.util.UUID;

import com.mansu.judger.language.Language;

public record Submission(
    UUID id,
    UUID problemId,
    UUID userId,
    Language language,
    String code
) {}
