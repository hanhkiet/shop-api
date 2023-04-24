package com.vti.group1.shopapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(
            @RequestParam String name) {
        User user = new User();
        user.setName(name);
        return ResponseEntity.ok().body(userRepository.save(user));
    }
}
