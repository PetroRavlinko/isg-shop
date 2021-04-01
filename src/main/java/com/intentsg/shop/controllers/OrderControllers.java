package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Order;
import com.intentsg.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderControllers {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("order", orderService.getCurrentOrder());
        return "order";
    }

    @GetMapping("/order/{orderId}")
    public String getOrderById(@PathVariable("orderId") Long id, Model model){
        model.addAttribute("orderById", orderService.getOrder(id));
        return "orderById";
    }

    @PostMapping("/order")
    public String createOrder(Model model) {
        model.addAttribute("newOrder", orderService.createOrder());
        return "newOrder";
    }

    @PutMapping("/order/{id}/{newValue}")
    public String updateOrder(@PathVariable("id") Long id,
                             @PathVariable("newValue") int newValue) {
        Order orderToUpdate = orderService.getOrder(id);
        orderService.updateOrder(orderToUpdate, newValue);
        return "redirect:order";
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Long id) {
        Order orderToDelete = orderService.getOrder(id);
        orderService.deleteOrder(orderToDelete);
        return "redirect:newOrder";
    }

}