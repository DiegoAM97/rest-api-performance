package com.api.users.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.api.users.entities.User;
import com.api.users.services.UserService;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> findAll(Pageable pageable, User user) {
        return this.userService.findAll(pageable, user);
    }

    
}
