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

    // Sipariþ koduna göre sipariþi almak için metod
    public Order getOrderForCode(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElseThrow(() -> new RuntimeException("Sipariþ bulunamadý!")); // Sipariþ yoksa hata fýrlat
    }
    // Müþteri ID'sine göre tüm sipariþleri almak için metod
    public List<Order> getAllOrdersFromCustomer(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}