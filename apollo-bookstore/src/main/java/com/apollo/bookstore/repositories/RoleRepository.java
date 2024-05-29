package com.apollo.bookstore.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apollo.bookstore.entities.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

  @Query("Select u From Role u where u.name = :name")
  Role findByName(String name);

}
