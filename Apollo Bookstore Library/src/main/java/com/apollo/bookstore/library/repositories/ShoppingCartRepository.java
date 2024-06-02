package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}