package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(value = "update cart_items set id = null where id = ?1", nativeQuery = true)
    void deleteCartItemById(Long cartId);
}