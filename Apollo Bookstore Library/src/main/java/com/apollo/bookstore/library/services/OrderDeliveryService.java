package com.apollo.bookstore.library.services;

import com.apollo.bookstore.library.dto.OrderDeliveryDto;
import com.apollo.bookstore.library.models.Order;
import com.apollo.bookstore.library.models.OrderDelivery;
import com.apollo.bookstore.library.models.User;

public interface OrderDeliveryService {
    OrderDelivery save(Order order, User user);

    OrderDelivery changeStatus(OrderDeliveryDto orderDeliveryDto);
}
