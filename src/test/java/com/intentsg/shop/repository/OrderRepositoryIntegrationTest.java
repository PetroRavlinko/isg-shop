package com.intentsg.shop.repository;

import com.intentsg.shop.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class OrderRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void whenFindById_thenReturnOrder() {
        // Given
        Order order = new Order();
        order.setSmthToUpdate(2);

        Long orderId = entityManager.persist(order).getId();

        // When
        Order actualOrder = orderRepository.findById(orderId).orElseThrow();

        // Then
        assertEquals(2, actualOrder.getSmthToUpdate());
    }

}
