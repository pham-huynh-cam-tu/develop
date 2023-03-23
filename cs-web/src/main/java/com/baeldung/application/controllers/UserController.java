package com.baeldung.application.controllers;

import com.baeldung.application.entities.User;
import com.baeldung.application.repositories.UserRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(maxAge = 3600)
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value = "/cs/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/users")
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

//    @PostMapping("/users")
    @PostMapping("/api/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}