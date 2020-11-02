package com.intentsg.shop.repository;

import com.intentsg.shop.model.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class OrdersRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void whenFindById_thenReturnOrder() {
        // Given
        Orders orders = new Orders();
        orders.setSmthToUpdate(2);

        Long orderId = entityManager.persist(orders).getId();
        entityManager.flush();

        // When
        Orders actualOrders = orderRepository.findById(orderId).orElseThrow();

        // Then
        assertEquals(2, actualOrders.getSmthToUpdate());
    }
//    @Test
//    void whenFindById_thenReturnOrder() {
//
//        Order order = new Order();
//        Order order1 = order;
//
//        assertEquals(order, order1);
//
//    }

}
