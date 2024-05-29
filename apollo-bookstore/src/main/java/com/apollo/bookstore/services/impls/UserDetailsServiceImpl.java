package com.apollo.bookstore.services.impls;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apollo.bookstore.entities.Role;
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
      return new org.springframework.security.core.userdetails.User(
          user.getEmail(),
          user.getPassword(),
          mapRolesToAuthorities(user.getRoles()));
    }

    throw new UsernameNotFoundException("User not found with username: " + username);
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }

}
