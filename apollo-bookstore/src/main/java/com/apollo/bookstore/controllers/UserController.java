package com.apollo.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.bookstore.entities.User;
import com.apollo.bookstore.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @GetMapping()
  public List<User> getMethodName() {
    return userRepository.findAll();
  }

}
