package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Order;
import com.intentsg.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrder() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    // /orders/42
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

    // POST /orders
    @PostMapping
    public ResponseEntity<HttpStatus> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT /orders/42
    @PutMapping("{orderId}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable("orderId") long id) {
        Order orderToUpdate = orderService.getOrder(id);
        orderService.updateOrder(orderToUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE /orders/42
    @DeleteMapping("{orderId}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId") long id) {
        Order orderToDelete = orderService.getOrder(id);
        orderService.deleteOrder(orderToDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}