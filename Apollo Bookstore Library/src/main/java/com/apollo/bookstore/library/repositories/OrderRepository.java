package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}