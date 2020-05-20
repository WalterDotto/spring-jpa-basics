package com.example.springjpa.controller;

import com.example.springjpa.data.entity.OrderEntity;
import com.example.springjpa.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders() {

        return orderRepository.findAll();
    }


}
