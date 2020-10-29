package com.intentsg.shop.services;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CartServiceImpl.class)
class CartServiceTest {

    private static final long EXPECTED_ID = 1L;
    private static final int SOME_VALUE = 12;
    private static final Object EXPECTED_CLASS = Cart.class;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImpl cartService;

    @Test
    void testCreateCart() {
        Cart cartToSave = new Cart();
        Cart fakeCart = new Cart();
        fakeCart.setId(EXPECTED_ID);
        given(cartRepository.createCartAtDB(eq(cartToSave))).willReturn(fakeCart);

        Cart actualCart = cartService.createCart();

        assertEquals(EXPECTED_ID, actualCart.getId());
    }

    @Test
    void testUpdateCart() {
        Cart cartToUpdate = new Cart();

        cartService.updateCart(cartToUpdate, SOME_VALUE);

        verify(cartRepository).updateCartAtDB(eq(cartToUpdate), eq(SOME_VALUE));
    }

    @Test
    void testGetCart() {
        Cart cartToGet;
        Cart fakeCart = new Cart();
        given(cartRepository.getCartFromDB(eq(EXPECTED_ID))).willReturn(fakeCart);

        cartToGet = cartService.getCart(EXPECTED_ID);
        verify(cartRepository).getCartFromDB(eq(EXPECTED_ID));

        assertEquals(EXPECTED_CLASS, cartToGet.getClass());
    }

    @Test
    void testDeleteCart() {
        Cart cartToDelete = new Cart();

        cartService.deleteCart(cartToDelete);

        verify(cartRepository).deleteFromDB(eq(cartToDelete));
    }

}
