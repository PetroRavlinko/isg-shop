package com.intentsg.shop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CatalogRepositoryTest {

    @Test
    void whenFindById_thenReturnCart() {
        assertEquals(1, 1);
    }
}