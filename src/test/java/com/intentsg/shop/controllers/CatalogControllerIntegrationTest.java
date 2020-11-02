package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.model.Catalog;
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
class CatalogControllerIntegrationTest {

    @MockBean
    private CatalogService catalogService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetCatalog_returnCatalogPage() throws Exception {
        // Given
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(1L);
        given(catalogService.createCatalog(fakeCatalog)).willReturn(new Catalog());

        // When
        mockMvc.perform(get("/catalog?id=1")).andDo(print()).andExpect(status().isOk());
    }
}

