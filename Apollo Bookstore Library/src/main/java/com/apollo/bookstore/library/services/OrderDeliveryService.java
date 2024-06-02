package com.apollo.bookstore.library.services;

import com.apollo.bookstore.library.dto.OrderDeliveryDto;
import com.apollo.bookstore.library.entities.Order;
import com.apollo.bookstore.library.entities.OrderDelivery;
import com.apollo.bookstore.library.entities.User;

public interface OrderDeliveryService {
    OrderDelivery save(Order order, User user);

    OrderDelivery changeStatus(OrderDeliveryDto orderDeliveryDto);
}
