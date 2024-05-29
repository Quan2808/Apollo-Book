package com.apollo.bookstore.configurations;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.apollo.bookstore.entities.*;
import com.apollo.bookstore.repositories.*;

import jakarta.annotation.PostConstruct;

@Configuration
public class UserRoleInitializerConfig {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private RoleRepository roleRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private final String[] roleNames = { "administrator", "customer", "reader" };

  @PostConstruct
  public void init() {
    initRoles();
    initAdminUser();
  }

  private void initRoles() {
    Set<String> existingRoles = new HashSet<>();
    roleRepo.findAll().forEach(role -> existingRoles.add(role.getName()));

    for (String roleName : roleNames) {
      if (!existingRoles.contains(roleName)) {
        Role role = new Role();
        role.setName(roleName);
        roleRepo.save(role);
      }
    }
  }

  private void initAdminUser() {
    if (userRepo.findByUsername("admin") == null) {
      Role adminRole = roleRepo.findByName("administrator");
      User adminUser = new User();
      adminUser.setUsername("admin");
      adminUser.setEmail("admin@apollo.com");
      adminUser.setPassword(passwordEncoder.encode("admin"));
      adminUser.setRoles(Collections.singleton(adminRole));
      userRepo.save(adminUser);
    }
  }

}
