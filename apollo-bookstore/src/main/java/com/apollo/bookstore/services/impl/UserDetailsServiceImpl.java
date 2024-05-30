package com.apollo.bookstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apollo.bookstore.configurations.UserDetailsInitializer;
import com.apollo.bookstore.entities.User;
import com.apollo.bookstore.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username);

    if (user != null) {
      return new UserDetailsInitializer(user);
    }

    throw new UsernameNotFoundException("User not found with username: " + username);
  }

}
