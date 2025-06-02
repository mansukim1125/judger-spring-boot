package com.mansu.judger.user;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponseDto> createUser(
        @RequestBody @Valid final CreateUserRequestDto request
    ) {
        UUID id = this.userService.createUser(request.name(), request.password(), request.email());
        CreateUserResponseDto responseDto = new CreateUserResponseDto(id);
        return ResponseEntity.created(URI.create("/users" + id)).body(responseDto);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable UUID id) {
        User user = this.userService.getUser(id);
        UserResponseDto responseDto = new UserResponseDto(user.name(), user.email());
        return ResponseEntity.ok().body(responseDto);
    }
}
