package com.intentsg.shop.services;

import com.intentsg.shop.model.Order;

public interface OrderService {

    Order getCurrentOrder();
    Order createOrder();
    void updateOrder(Order order, int newSomeValue);
    void deleteOrder(Order orderToDelete);
    Order getOrder(long id);

}