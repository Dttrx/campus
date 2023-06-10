package com.imf.campus.controller;

import com.imf.campus.model.entity.User;
import com.imf.campus.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/getall/user")
    public List<User> getAll() {
        return repository.findAll();
    }

    @PostMapping("/add/user")
    public void addUser(@RequestBody User user) {
        repository.save(user);
    }
}
