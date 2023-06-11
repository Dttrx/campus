package com.imf.campus.controller;

import com.imf.campus.model.entity.User;
import com.imf.campus.model.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return repository.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }
}
