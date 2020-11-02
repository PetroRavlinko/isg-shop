package com.intentsg.shop.controllers;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CatalogControllerIntegrationTest {

    @MockBean
    private CatalogService catalogService;
    @MockBean
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetCatalog_returnCatalogPage() throws Exception {
        // Given
        given(catalogService.getCatalogById(1L)).willReturn(new Catalog());

        // When
        mockMvc.perform(get("/catalog?id=1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void whenCreateCatalog_thenRerurn200() throws Exception {
        // Given
        Catalog catalog = new Catalog();

        given( catalogService.createCatalog( catalog ) ).willReturn( catalog );

        // When
        mockMvc.perform( post( "/catalog" ) )
                .andDo( print() ).andExpect( status().is( 400 ) );
    }
}

