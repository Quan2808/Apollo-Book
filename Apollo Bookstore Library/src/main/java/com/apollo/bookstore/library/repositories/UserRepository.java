package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.entities.User;
import org.springframework.data.jpa.repository.*;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("Select u From User u where u.username = :name")
    User findByUsername(String name);
}