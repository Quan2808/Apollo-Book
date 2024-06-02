package com.apollo.bookstore.library.services.impl;

import com.apollo.bookstore.library.dto.OrderDeliveryDto;
import com.apollo.bookstore.library.models.Order;
import com.apollo.bookstore.library.models.OrderDelivery;
import com.apollo.bookstore.library.models.User;
import com.apollo.bookstore.library.repositories.OrderDeliveryRepository;
import com.apollo.bookstore.library.repositories.OrderRepository;
import com.apollo.bookstore.library.services.OrderDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor()
public class OrderDeliveryServiceImpl implements OrderDeliveryService {

    private final OrderRepository orderRepository;
    private final OrderDeliveryRepository orderDeliveryRepository;

    @Override
    public OrderDelivery save(Order order, User user) {
        Date date = new Date();
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setOrder(order);
        orderDelivery.setUser(user);
//        orderDelivery.setStatus("Processing");
        orderDelivery.setStatus("Pending");
        orderDelivery.setAssignedDate(date);
        order.setDeliveryDate(date);

        orderRepository.save(order);
        return orderDeliveryRepository.save(orderDelivery);
    }

    @Override
    public OrderDelivery changeStatus(OrderDeliveryDto orderDeliveryDto) {
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setStatus(orderDeliveryDto.getStatus());
        return orderDeliveryRepository.save(orderDelivery);
    }
}
