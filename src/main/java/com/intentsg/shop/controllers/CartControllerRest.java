package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartRest")
public class CartControllerRest {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<Cart> getCart(){
        return new ResponseEntity<>(cartService.getCurrentCart(), HttpStatus.OK);
    }

    @GetMapping("{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable("cartId") long id){
        return new ResponseEntity<>(cartService.getCart(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createCart (){
        cartService.createCart();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}/{newValue}")
    public ResponseEntity<HttpStatus> updateCart(@PathVariable("id") long id,
                                        @PathVariable("newValue") int newValue){
        Cart cartToUpdate = cartService.getCart(id);
        cartService.updateCart(cartToUpdate, newValue);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{cartId}")
    public ResponseEntity<HttpStatus> deleteCart(@PathVariable("cartId") long id){
        Cart cartToDelete = cartService.getCart(id);
        cartService.deleteCart(cartToDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
