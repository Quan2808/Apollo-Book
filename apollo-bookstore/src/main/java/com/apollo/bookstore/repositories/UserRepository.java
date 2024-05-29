package com.apollo.bookstore.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.*;

import com.apollo.bookstore.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  @Query("Select u From User u where u.username = :name")
  User findByUsername(String name);

}
