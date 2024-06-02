package com.apollo.bookstore.server.initializer;

import com.apollo.bookstore.library.models.User;
import com.apollo.bookstore.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceInitializer implements UserDetailsService {

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
