package com.intentsg.shop.services;

import com.intentsg.shop.models.Order;
import com.intentsg.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

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
