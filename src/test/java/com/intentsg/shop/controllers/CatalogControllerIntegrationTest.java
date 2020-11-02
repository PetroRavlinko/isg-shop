package com.intentsg.shop.controllers;

import com.intentsg.shop.services.CatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CatalogController.class)
class CatalogControllerIntegrationTest {

    @MockBean
    private CatalogService catalogService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetCatalog_returnStatus200() throws Exception {
        mockMvc.perform(get("/catalog?id=1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void whenCreateCatalog_returnStatus201() throws Exception {
        mockMvc.perform( post( "/catalog" )
                .content( "{\"title\": \"some title\"}" )
                .contentType( MediaType.APPLICATION_JSON ))
                .andDo( print() ).andExpect( status().isCreated() );
    }

    @Test
    void whenDeleteCatalog_rerurnStatus200() throws Exception {
        mockMvc.perform( delete( "/catalog?id=1" ) ).andDo( print() ).andExpect( status().isOk() );
    }
}

