package com.intentsg.shop.controllers;

import com.intentsg.shop.dto.CartDTO;
import com.intentsg.shop.model.Cart;
import com.intentsg.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", cartService.getCurrentCart());
        return "cart";
    }

    @GetMapping("/cart/{cartId}")
    public String getCartById(@PathVariable("cartId") Long id, Model model){
        model.addAttribute("cartById", cartService.getCart(id));
        return "cartById";
    }

    @PostMapping("/cart")
    public String createCart(Model model) {
        model.addAttribute("newCart", cartService.createCart());
        return "newCart";
    }

    @PutMapping("/cart")
    public void updateCart(@RequestParam Long id,
                             @RequestParam int newValue) {
        Cart cartToUpdate = cartService.getCart(id);
        cartService.updateCart(cartToUpdate, newValue);
    }

    @DeleteMapping("/cart")
    public String deleteCart(@RequestParam Long id) {
        Cart cartToDelete = cartService.getCart(id);
        cartService.deleteCart(cartToDelete);
        return "cart";
    }



}
