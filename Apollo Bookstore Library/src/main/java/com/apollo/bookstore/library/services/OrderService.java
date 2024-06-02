package com.apollo.bookstore.library.services;

import com.apollo.bookstore.library.entities.Order;
import com.apollo.bookstore.library.entities.ShoppingCart;

import java.util.List;

public interface OrderService {
    Order save(ShoppingCart shoppingCart);

    List<Order> findAll(String username);

    List<Order> findALlOrders();

    Order acceptOrder(Long id);

    void cancelOrder(Long id);
}
