package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.services.CartService;
import com.intentsg.shop.services.impl.CartServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CartControllerRest.class)
class CartControllerRestIntegrationTest {

    @MockBean
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    private static final long FAKE_ID = 1L;
    private static final int FAKE_VALUE = 1;


    @Test
    void shouldReturnCurrentCart() throws Exception{
        Cart fakeCart = new Cart();

        given(cartService.getCurrentCart()).willReturn(fakeCart);

        mockMvc.perform(get("/cartsRest"))
                        .andExpect(status().isOk());
    }

    @Test
    void shouldReturnCartById() throws Exception{
        Cart fakeCart = new Cart();
        fakeCart.setId(FAKE_ID);
        fakeCart.setSmthToUpdate(FAKE_VALUE);

        given(cartService.getCart(fakeCart.getId())).willReturn(fakeCart);

        mockMvc.perform(get("/cartsRest/{cartId}", fakeCart.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatusCreated_afterCartCreating() throws Exception{
        given(cartService.createCart()).willReturn(new Cart());

        mockMvc.perform(post("/cartsRest"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnStatusOk_afterCartUpdating() throws Exception{
        Cart fakeCart = new Cart();
        fakeCart.setId(FAKE_ID);

        given(cartService.getCart(FAKE_ID)).willReturn(fakeCart);
        Cart cartToUpdate = cartService.getCart(FAKE_ID);
        doNothing().when(cartService).updateCart(cartToUpdate, FAKE_VALUE);

        mockMvc.perform(put("/cartsRest/{id}/{newValue}", FAKE_ID, FAKE_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatusOk_afterCartDeleting() throws Exception{
        Cart fakeCart = new Cart();
        fakeCart.setId(FAKE_ID);

        given(cartService.getCart(FAKE_ID)).willReturn(fakeCart);
        Cart cartToDelete = cartService.getCart(FAKE_ID);
        doNothing().when(cartService).deleteCart(cartToDelete);

        mockMvc.perform(delete("/cartsRest/{cartId}", FAKE_ID))
                .andExpect(status().isOk());
    }

}
