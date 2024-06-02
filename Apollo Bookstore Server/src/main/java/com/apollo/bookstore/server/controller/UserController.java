package com.apollo.bookstore.server.controller;

import com.apollo.bookstore.library.entities.User;
import com.apollo.bookstore.library.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
