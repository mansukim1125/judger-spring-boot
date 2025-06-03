package com.mansu.judger.user;

import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<UUID, User> users = new ConcurrentHashMap<UUID, User>();

    public User findOne(final UUID id) {
        User user = this.users.get(id);
        return new User(
            user.id(),
            user.name(),
            user.password(),
            user.email()
        );
    }

    public void create(User user) {
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
