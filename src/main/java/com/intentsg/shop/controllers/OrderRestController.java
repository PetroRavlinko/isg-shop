package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Order;
import com.intentsg.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Order> getOrder() {
        return new ResponseEntity<>(orderService.getCurrentOrder(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createOrder() {
        orderService.createOrder();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}/{newValue}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable("id") long id,
                                                 @PathVariable("newValue") int newValue) {
        Order orderToUpdate = orderService.getOrder(id);
        orderService.updateOrder(orderToUpdate, newValue);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId") long id) {
        Order orderToDelete = orderService.getOrder(id);
        orderService.deleteOrder(orderToDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}