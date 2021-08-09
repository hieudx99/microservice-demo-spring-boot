package com.eureka.user.controller;


import com.eureka.user.model.User;
import com.eureka.user.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public void create (@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) throws NotFoundException {
        return userService.findById(id);
    }

    @GetMapping(value = "/username/{username}")
    public User findByUsername(@PathVariable String username) throws NotFoundException {
        return userService.findByUsername(username);
    }

}
