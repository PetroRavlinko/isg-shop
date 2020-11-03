package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.services.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CartControllerIntegrationTest {

    @MockBean
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    private static final long FAKE_ID = 1L;
    private static final int FAKE_VALUE = 4543;

    @Test
    void whenGetCart_returnCartPage() throws Exception {
        // Given
        given(cartService.getCurrentCart()).willReturn(new Cart());

        // When
        mockMvc.perform(get("/cart")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void whenGetCartById_returnCartPage() throws Exception {
        given(cartService.getCart(FAKE_ID)).willReturn(new Cart());
        mockMvc.perform(get("/cart/{cartId}", FAKE_ID)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void whenCreateCart_returnCartPage() throws Exception {
        given(cartService.createCart()).willReturn(new Cart());
        mockMvc.perform(post("/cart")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void whenUpdateCart_returnStatusRedirect() throws Exception {
        Cart fakeCart = new Cart();
        fakeCart.setId(FAKE_ID);
        fakeCart.setSmthToUpdate(FAKE_VALUE);

        given(cartService.getCart(FAKE_ID)).willReturn(fakeCart);

        mockMvc.perform(put("/cart/{id}/{newValue}", fakeCart.getId(), fakeCart.getSmthToUpdate())).andExpect(status().is3xxRedirection());

    }

    @Test
    void whenPutNoParamToUpdate_thenBadRequest() throws Exception {

        mockMvc.perform(put("/cart"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenDelete_thenReturnStatusRedirect() throws Exception {
        Cart fakeCart = new Cart();
        fakeCart.setId(FAKE_ID);

        given(cartService.getCart(FAKE_ID)).willReturn(fakeCart);

        mockMvc.perform(delete("/cart/{cartId}", fakeCart.getId())).andExpect(status().is3xxRedirection());
    }

}