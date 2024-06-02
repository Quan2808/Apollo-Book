package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.models.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("Select u From User u where u.username = :name")
    User findByUsername(String name);
}