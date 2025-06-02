package com.mansu.judger.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequestDto(
    @NotEmpty String name,
    @NotEmpty String password,
    @NotEmpty @Email String email
) {}
