package com.api.users.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.api.users.entities.User;
import com.api.users.services.UserService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<Page<User>> findAll(Pageable pageable, User user) {
        Page<User> users = userService.findAll(user, pageable);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByUserId(@PathVariable Integer id) {
        Optional<User> user = userService.findByUserId(id);

        if (user.isPresent())
            return ResponseEntity.ok().body(user.get());
        
        return ResponseEntity.badRequest().body("User doesn't exist");
    }

    
}
