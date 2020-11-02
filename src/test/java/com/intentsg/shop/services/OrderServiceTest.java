package com.intentsg.shop.services;


import com.intentsg.shop.models.Order;
import com.intentsg.shop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = OrderServiceImpl.class)
public class OrderServiceTest {
    private static final long EXPECTED_ID = 1L;
    private static final int SOME_VALUE = 2;
    private static final Object EXPECTED_CLASS = Order.class;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void testCreateCart() {
        Order fakeOrder = new Order();
        fakeOrder.setId(EXPECTED_ID);
        given(orderRepository.save(any())).willReturn(fakeOrder);

        Order actualOrder = orderService.createOrder();

        assertEquals(fakeOrder.getId(), actualOrder.getId());
    }

    @Test
    void testUpdateCart() {
        Order orderToUpdate = new Order();

        orderService.updateOrder(orderToUpdate, SOME_VALUE);

        verify(orderRepository).save(eq(orderToUpdate));
    }

    @Test
    void testGetCart() {
        Order orderToGet;
        Order fakeOrder = new Order();
        given(orderRepository.findById(eq(EXPECTED_ID))).willReturn(Optional.of(fakeOrder));

        orderToGet = orderService.getOrder(EXPECTED_ID);
        verify(orderRepository).findById(eq(EXPECTED_ID));

        assertEquals(EXPECTED_CLASS, orderToGet.getClass());
    }

    @Test
    void testDeleteCart() {
        Order orderToDelete = new Order();

        orderService.deleteOrder(orderToDelete);

        verify(orderRepository).delete(eq(orderToDelete));
    }
}
