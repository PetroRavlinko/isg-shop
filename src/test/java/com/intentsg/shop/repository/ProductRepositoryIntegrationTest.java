package com.intentsg.shop.repository;

import com.intentsg.shop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void whenFindById_thenReturnProduct() {
        // Given
        Product product = new Product();
        product.setTitle("s");

        Long productId = entityManager.persist(product).getId();
        entityManager.flush();

        // When
        Product actualCart = productRepository.findById(productId).orElseThrow();

        // Then
        assertEquals("s", actualCart.getTitle());
    }
}