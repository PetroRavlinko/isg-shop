package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Order;
import com.intentsg.shop.repository.OrderRepository;
import com.intentsg.shop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private Order currentOrder;

    @Override
    public Order getCurrentOrder()  {
        
        return this.currentOrder;
    }


    @Override
    public Order createOrder() {
        return orderRepository.save(new Order());
    }

    @Override
    public void updateOrder(Order order, int newSomeValue) {
        order.setSmthToUpdate(newSomeValue);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order orderToDelete) {
        orderRepository.delete(orderToDelete);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
