package com.intentsg.shop.services;

import com.intentsg.shop.models.Order;

public interface OrderService {

    Order createOrder();
    void updateOrder(Order order, int newSomeValue);
    void deleteOrder(Order orderToDelete);
    Order getOrder(long id);

}