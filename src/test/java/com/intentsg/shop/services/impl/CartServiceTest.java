package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.repository.CartRepository;
import com.intentsg.shop.services.CartService;
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

@SpringBootTest(classes = CartServiceImpl.class)
class CartServiceTest {

    private static final long EXPECTED_ID = 1L;
    private static final int SOME_VALUE = 12;
    private static final Object EXPECTED_CLASS = Cart.class;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @Test
    void testCreateCart() {
        Cart fakeCart = new Cart();
        fakeCart.setId(EXPECTED_ID);
        given(cartRepository.save(any())).willReturn(fakeCart);

        Cart actualCart = cartService.createCart();

        assertEquals(fakeCart.getId(), actualCart.getId());
    }

    @Test
    void testUpdateCart() {
        Cart cartToUpdate = new Cart();

        cartService.updateCart(cartToUpdate, SOME_VALUE);

        verify(cartRepository).save(eq(cartToUpdate));
    }

    @Test
    void testGetCart() {
        Cart cartToGet;
        Cart fakeCart = new Cart();
        given(cartRepository.findById(eq(EXPECTED_ID))).willReturn(Optional.of(fakeCart));

        cartToGet = cartService.getCart(EXPECTED_ID);
        verify(cartRepository).findById(eq(EXPECTED_ID));

        assertEquals(EXPECTED_CLASS, cartToGet.getClass());
    }

    @Test
    void testDeleteCart() {
        Cart cartToDelete = new Cart();
        cartService.deleteCart(cartToDelete);
        verify(cartRepository).delete(eq(cartToDelete));
    }

}
