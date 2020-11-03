package com.intentsg.shop.controllers;

import com.intentsg.shop.services.CartService;
import com.intentsg.shop.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerIntegrationTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetProductById_returnProductPage() throws Exception {
        mockMvc.perform(get("/products?id=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void whenCreateProduct_returnCreatedProduct() throws Exception {
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"title\" : \"elem\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void whenDeleteProduct_returnDeletedProduct() throws Exception{
        mockMvc.perform( delete("/products?id=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void whenUpdateProduct_returnUpdatedProduct() throws Exception{
        mockMvc.perform(put("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"title\" : \"elem\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }


}