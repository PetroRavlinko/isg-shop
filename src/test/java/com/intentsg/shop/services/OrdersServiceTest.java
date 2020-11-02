package com.intentsg.shop.services;


import com.intentsg.shop.model.Orders;
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
class OrdersServiceTest {
    private static final long EXPECTED_ID = 1L;
    private static final int SOME_VALUE = 2;
    private static final Object EXPECTED_CLASS = Orders.class;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void testCreateOrder() {
        Orders fakeOrders = new Orders();
        fakeOrders.setId(EXPECTED_ID);
        given(orderRepository.save(any())).willReturn(fakeOrders);

        Orders actualOrders = orderService.createOrder();

        assertEquals(fakeOrders.getId(), actualOrders.getId());
    }

    @Test
    void testUpdateOrder() {
        Orders ordersToUpdate = new Orders();

        orderService.updateOrder(ordersToUpdate, SOME_VALUE);

        verify(orderRepository).save(eq(ordersToUpdate));
    }

    @Test
    void testGetOrder() {
        Orders ordersToGet;
        Orders fakeOrders = new Orders();
        given(orderRepository.findById(eq(EXPECTED_ID))).willReturn(Optional.of(fakeOrders));

        ordersToGet = orderService.getOrder(EXPECTED_ID);
        verify(orderRepository).findById(eq(EXPECTED_ID));

        assertEquals(EXPECTED_CLASS, ordersToGet.getClass());
    }

    @Test
    void testDeleteOrder() {
        Orders ordersToDelete = new Orders();

        orderService.deleteOrder(ordersToDelete);

        verify(orderRepository).delete(eq(ordersToDelete));
    }
}
