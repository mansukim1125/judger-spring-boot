package com.mansu.judger.user;

import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<UUID, User> users = new ConcurrentHashMap<UUID, User>();

    public User findOne(final UUID id) {
        return this.users.get(id);
    }

    public void create(User user) {
        this.users.put(user.id(), user);
    }
}
