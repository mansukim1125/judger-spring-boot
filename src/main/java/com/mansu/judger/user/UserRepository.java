package com.mansu.judger.user;

import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<UUID, User> users = new ConcurrentHashMap<UUID, User>();

    public User findOne(final UUID id) {
        User user = this.users.get(id);
        if (user == null) return null;
        return new User(
            user.id(),
            user.name(),
            user.password(),
            user.email()
        );
    }

    public void create(User user) {
        UUID id = user.id();
        String email = user.email();

        boolean alreadyExists =
            this.users.containsKey(id) ||
            this.users.values()
                .stream()
                .anyMatch(u -> u.email() == email);

        if (alreadyExists) {
            throw new UserAlreadyExistsException("이미 존재하는 유저입니다.");
        }

        this.users.put(
            user.id(),
            new User(
                user.id(),
                user.name(),
                user.password(),
                user.email()
            )
        );
    }
}
