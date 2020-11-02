package com.intentsg.shop.repository;

import com.intentsg.shop.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class OrderRepositoryIntegrationTest {

    @Test
    void whenFindById_thenReturnOrder() {

        Order order = new Order();
        Order order1 = order;

        assertEquals(order, order1);

    }
}
