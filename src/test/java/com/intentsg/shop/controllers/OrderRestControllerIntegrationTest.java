package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Order;
import com.intentsg.shop.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderRestController.class)
class OrderRestControllerIntegrationTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    private static final long FAKE_ID = 1L;
    private static final int FAKE_VALUE = 1;


    @Test
    void shouldReturnCurrentOrder() throws Exception{
        Order myOrder = new Order();

        given(orderService.getCurrentOrder()).willReturn(myOrder);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnOrderById() throws Exception{
        Order myOrder = new Order();
        myOrder.setId(FAKE_ID);
        myOrder.setSmthToUpdate(FAKE_VALUE);

        given(orderService.getOrder(myOrder.getId())).willReturn(myOrder);

        mockMvc.perform(get("/orders/{orderId}", myOrder.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatusCreated_afterOrderCreating() throws Exception{
        given(orderService.createOrder(any())).willReturn(new Order());

        mockMvc.perform(post("/orders"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnStatusOk_afterOrderUpdating() throws Exception{
        Order myOrder = new Order();
        myOrder.setId(FAKE_ID);

        given(orderService.getOrder(FAKE_ID)).willReturn(myOrder);
        Order orderToUpdate = orderService.getOrder(FAKE_ID);
        doNothing().when(orderService).updateOrder(orderToUpdate);

        mockMvc.perform(put("/orders/{orderId}", FAKE_ID))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatusOk_afterOrderDeleting() throws Exception{
        Order myOrder = new Order();
        myOrder.setId(FAKE_ID);

        given(orderService.getOrder(FAKE_ID)).willReturn(myOrder);
        Order orderToDelete = orderService.getOrder(FAKE_ID);
        doNothing().when(orderService).deleteOrder(orderToDelete);

        mockMvc.perform(delete("/orders/{orderId}", FAKE_ID))
                .andExpect(status().isOk());
    }

}