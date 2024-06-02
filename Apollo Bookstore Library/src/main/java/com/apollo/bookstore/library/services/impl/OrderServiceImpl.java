package com.apollo.bookstore.library.services.impl;

import com.apollo.bookstore.library.entities.*;
import com.apollo.bookstore.library.repositories.OrderDetailRepository;
import com.apollo.bookstore.library.repositories.OrderRepository;
import com.apollo.bookstore.library.repositories.UserRepository;
import com.apollo.bookstore.library.services.OrderService;
import com.apollo.bookstore.library.services.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository detailRepository;
    private final UserRepository userRepository;
    private final ShoppingCartService shoppingCartService;

    @Override
    public Order save(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setUser(shoppingCart.getUser());
        order.setTax(2);
        order.setTotalPrice(shoppingCart.getTotalPrice());
        order.setAccept(false);
        order.setPaymentMethod("Cash");
        order.setOrderStatus("Pending");
        order.setQuantity(shoppingCart.getTotalItems());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartItem item : shoppingCart.getCartItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(item.getProduct());
            detailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
        }
        order.setOrderDetailList(orderDetailList);
        shoppingCartService.deleteCartById(shoppingCart.getId());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll(String username) {
        User user = userRepository.findByUsername(username);
        return user.getOrders();
    }

    @Override
    public List<Order> findALlOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order acceptOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setAccept(true);
            order.setDeliveryDate(new Date());
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
