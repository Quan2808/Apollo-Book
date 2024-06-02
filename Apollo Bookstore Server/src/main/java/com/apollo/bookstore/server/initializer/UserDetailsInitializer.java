package com.apollo.bookstore.server.initializer;

import com.apollo.bookstore.library.models.Role;
import com.apollo.bookstore.library.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetailsInitializer  implements UserDetails {

  private final User user;

  public UserDetailsInitializer(User user) {
      this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      Set<Role> roles = user.getRoles();
      List<SimpleGrantedAuthority> authorities = new ArrayList<>();

      for (Role role : roles) {
          authorities.add(new SimpleGrantedAuthority(role.getName()));
      }

      return authorities;
  }

  @Override
  public String getPassword() {
      return user.getPassword();
  }

  @Override
  public String getUsername() {
      return user.getUsername();
  }

}
