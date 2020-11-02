package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.services.CartService;
import com.intentsg.shop.services.CatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CartControllerIntegrationTest {

    @MockBean
    private CartService cartService;
    @MockBean
    private CatalogService catalogService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetCart_returnCartPage() throws Exception {
        // Given
        given(cartService.getCurrentCart()).willReturn(new Cart());

        // When
        mockMvc.perform(get("/cart")).andDo(print()).andExpect(status().isOk());
    }
}