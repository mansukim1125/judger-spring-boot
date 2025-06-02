package com.mansu.judger.user;

import java.util.UUID;

public record User(UUID id, String name, String password, String email) {}
