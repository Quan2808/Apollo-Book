package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    @Query("Select u From Role u where u.name = :name")
    Role findByName(String name);
}