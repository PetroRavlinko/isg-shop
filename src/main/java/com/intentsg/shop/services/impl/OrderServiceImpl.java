package com.intentsg.shop.services.impl;

import java.util.List;

import javax.transaction.Transactional;

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
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public void updateOrder(Order sourceOrder) {
        Order originOrder = orderRepository.findById(sourceOrder.getId()).orElseThrow();
        originOrder.setCustomer(sourceOrder.getCustomer());
        originOrder.setSmthToUpdate(sourceOrder.getSmthToUpdate());
        orderRepository.save(originOrder);
    }

    @Override
    public void deleteOrder(Order orderToDelete) {
        orderRepository.delete(orderToDelete);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow();
    }


    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
