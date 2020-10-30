package com.intentsg.shop.repository;

import com.intentsg.shop.model.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CartRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CartRepository cartRepository;

    @Test
    void whenFindById_thenReturnCart() {
        // Given
        Cart cart = new Cart();
        cart.setSmthToUpdate(42);

        Long cartId = entityManager.persist(cart).getId();
        entityManager.flush();

        // When
        Cart actualCart = cartRepository.findById(cartId).orElseThrow();

        // Then
        assertEquals(42, actualCart.getSmthToUpdate());
    }
}