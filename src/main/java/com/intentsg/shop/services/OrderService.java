package com.intentsg.shop.services;

import java.util.List;

import com.intentsg.shop.model.Order;


public interface OrderService {

    Order getCurrentOrder();
    Order createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Order orderToDelete);
    Order getOrder(long id);
    List<Order> getAll();
}