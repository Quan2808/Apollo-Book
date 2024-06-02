package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.entities.Order;
import com.apollo.bookstore.library.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("select o from Order o where o.user.id = :id")
    List<Order> findByUser(Long id);
}