package com.intentsg.shop.services.impl;


import com.intentsg.shop.model.Order;
import com.intentsg.shop.repository.OrderRepository;
import com.intentsg.shop.services.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = OrderServiceImpl.class)
class OrderServiceTest {
    private static final long EXPECTED_ID = 1L;
    private static final int SOME_VALUE = 2;
    private static final Object EXPECTED_CLASS = Order.class;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void testCreateOrder() {
        Order fakeOrder = new Order();
        fakeOrder.setId(EXPECTED_ID);
        given(orderRepository.save(any())).willReturn(fakeOrder);

        Order actualOrder = orderService.createOrder(new Order());

        assertEquals(EXPECTED_ID, actualOrder.getId());
    }

    @Test
    void testUpdateOrder() {
        Order orderToUpdate = new Order();

        orderService.updateOrder(orderToUpdate);

        verify(orderRepository).save(orderToUpdate);
    }

    @Test
    void testGetOrder() {
        Order orderToGet;
        Order fakeOrder = new Order();
        given(orderRepository.findById(EXPECTED_ID)).willReturn(Optional.of(fakeOrder));

        orderToGet = orderService.getOrder(EXPECTED_ID);
        verify(orderRepository).findById(EXPECTED_ID);

        assertEquals(EXPECTED_CLASS, orderToGet.getClass());
    }

    @Test
    void testDeleteOrder() {
        Order orderToDelete = new Order();

        orderService.deleteOrder(orderToDelete);

        verify(orderRepository).delete(orderToDelete);
    }
}
