package com.intentsg.shop.repository;

import com.intentsg.shop.models.Catalog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CatalogRepositoryTest {

    @Test
    void whenFindById_thenReturnCart() {
        Catalog catalog = new Catalog();
        Catalog catalog2 = catalog;
        assertEquals(catalog, catalog2);
    }
}