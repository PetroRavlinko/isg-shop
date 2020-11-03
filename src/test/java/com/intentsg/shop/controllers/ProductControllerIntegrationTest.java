package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Product;
import com.intentsg.shop.services.CartService;
import com.intentsg.shop.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerIntegrationTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetProduct_returnProductPage() throws Exception {
        // Given
        Product product = new Product();
        product.setTitle("s");
        given(productService.getCurrentProduct())
                .willReturn(product);

        // When
        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("product", product));
    }

    @Test
    void whenCreateProduct_returnCreatedProduct() throws Exception {
        // Given
        Product product = new Product();
        product.setTitle("s");
        given(productService.createProduct())
                .willReturn(product);

        // When
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"title\" : \"elem\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("product", product));
    }


}