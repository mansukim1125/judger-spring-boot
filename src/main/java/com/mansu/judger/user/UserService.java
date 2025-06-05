package com.mansu.judger.user;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(String name, String password, String email) {
        UUID id = UUID.randomUUID();
        User newUser = new User(id, name, password, email);
        this.userRepository.create(newUser);
        return id;
    }

    public User getUser(UUID id) {
        User user = this.userRepository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("유저가 존재하지 않습니다.");
        }
        return user;
    }
}
