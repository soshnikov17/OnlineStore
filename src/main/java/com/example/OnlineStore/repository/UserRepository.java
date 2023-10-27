package com.example.OnlineStore.repository;

import com.example.OnlineStore.entity.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new LinkedList<>();

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.get(id);
    }

    public User save(User entity) {
        users.add(entity);
        return entity;
    }

    public User remove(User entity) {
        users.add(entity);
        return entity;
    }

    public User removeById(int id) {
        User entity = users.get(id);
        users.remove(id);
        return entity;
    }
}
