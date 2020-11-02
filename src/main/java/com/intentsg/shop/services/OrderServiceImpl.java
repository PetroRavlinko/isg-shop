package com.intentsg.shop.services;

import com.intentsg.shop.model.Orders;
import com.intentsg.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Orders createOrder() {
        return orderRepository.save(new Orders());
    }

    @Override
    public void updateOrder(Orders orders, int newSomeValue) {
        orders.setSmthToUpdate(newSomeValue);
        orderRepository.save(orders);
    }

    @Override
    public void deleteOrder(Orders ordersToDelete) {
        orderRepository.delete(ordersToDelete);
    }

    @Override
    public Orders getOrder(long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
