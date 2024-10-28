package com.giray.controller;


import com.giray.entity.Order;
import com.giray.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.giray.constants.RestApiUrls.ORDER;

@RestController
@RequestMapping(ORDER)
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public Order getOrderForCode(@PathVariable("orderId") String orderId) {
        return orderService.getOrderForCode(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrdersFromCustomer(@PathVariable("customerId") String customerId) {
        return orderService.getAllOrdersFromCustomer(customerId);
    }
}