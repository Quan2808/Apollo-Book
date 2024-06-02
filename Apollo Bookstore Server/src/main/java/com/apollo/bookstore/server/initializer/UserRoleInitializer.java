package com.apollo.bookstore.server.initializer;

import com.apollo.bookstore.library.models.Role;
import com.apollo.bookstore.library.models.User;
import com.apollo.bookstore.library.repositories.RoleRepository;
import com.apollo.bookstore.library.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class UserRoleInitializer {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String[] roleNames = {"administrator", "customer", "delivery"};

    @PostConstruct
    public void init() {
        initRoles();
        initAdminUser();
    }

    private void initRoles() {
        Set<String> existingRoles = roleRepo.findAll().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        Arrays.stream(roleNames)
                .filter(roleName -> !existingRoles.contains(roleName))
                .forEach(roleName -> {
                    Role role = new Role();
                    role.setName(roleName);
                    roleRepo.save(role);
                });
    }

    private void initAdminUser() {
        Role adminRole = roleRepo.findByName("administrator");
        User adminUser = new User();
        if (userRepo.findByUsername("admin") == null) {
            adminUser.setUsername("admin");
            adminUser.setEmail("admin@apollo.com");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.setRoles(Collections.singleton(adminRole));
            userRepo.save(adminUser);
        }
    }

    private void initCustomerUser() {
        Role adminRole = roleRepo.findByName("customer");
        User adminUser = new User();
        if (userRepo.findByUsername("customer") == null) {
            adminUser.setUsername("customer");
            adminUser.setEmail("customer@apollo.com");
            adminUser.setPassword(passwordEncoder.encode("customer"));
            adminUser.setRoles(Collections.singleton(adminRole));
            userRepo.save(adminUser);
        }
    }
}
