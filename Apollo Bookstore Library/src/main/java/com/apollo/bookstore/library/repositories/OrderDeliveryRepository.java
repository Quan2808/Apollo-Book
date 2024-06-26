package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.models.OrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, Long> {
}