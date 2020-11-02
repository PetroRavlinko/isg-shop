package com.intentsg.shop.services;

import com.intentsg.shop.model.Orders;

public interface OrderService {

    Orders createOrder();
    void updateOrder(Orders orders, int newSomeValue);
    void deleteOrder(Orders ordersToDelete);
    Orders getOrder(long id);

}