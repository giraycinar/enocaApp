package com.giray.service;


import com.giray.entity.Order;
import com.giray.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderForCode(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElseThrow(() -> new RuntimeException("Sipariþ bulunamadý!"));
    }
    public List<Order> getAllOrdersFromCustomer(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}