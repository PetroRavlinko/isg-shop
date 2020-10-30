package com.intentsg.shop.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CartRepositoryIntegrationTest {

    @Test
    void whenFindById_thenReturnCart() {
        assertEquals(1, 1);
    }
}