package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Order;
import com.intentsg.shop.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderControllers.class)
class OrderControllerIntegrationTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    private static final long FAKE_ID = 1L;
    private static final int FAKE_VALUE = 4543;

    @Test
    void whenGetOrder_returnOrderPage() throws Exception {
        // Given
        given(orderService.getCurrentOrder()).willReturn(new Order());

        // When
        mockMvc.perform(get("/order")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void whenGetOrderById_returnOrderPage() throws Exception {
        given(orderService.getOrder(FAKE_ID)).willReturn(new Order());
        mockMvc.perform(get("/order", FAKE_ID)).andDo(print()).andExpect(status().isOk());
    }

//    @Test
//    void whenCreateOrder_returnOrderPage() throws Exception {
//        given(orderService.createOrder()).willReturn(new Orders());
//        mockMvc.perform(post("/order")).andDo(print()).andExpect(status().isOk());
//    }

    @Test
    void whenUpdateOrder_returnStatusRedirect() throws Exception {
        Order myOrder = new Order();
        myOrder.setId(FAKE_ID);
        myOrder.setSmthToUpdate(FAKE_VALUE);

        given(orderService.getOrder(FAKE_ID)).willReturn(myOrder);

        mockMvc.perform(put("/order/{id}/{newValue}", myOrder.getId(), myOrder.getSmthToUpdate())).andExpect(status().is3xxRedirection());

    }

    @Test
    void whenDelete_thenReturnStatusRedirect() throws Exception {
        Order myOrder = new Order();
        myOrder.setId(FAKE_ID);

        given(orderService.getOrder(FAKE_ID)).willReturn(myOrder);

        mockMvc.perform(delete("/order/{orderId}", myOrder.getId())).andExpect(status().is3xxRedirection());
    }

}