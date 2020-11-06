package com.intentsg.shop.controllers;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/cart/{id}/{newValue}")
    public String updateCart(@PathVariable("id") Long id,
                             @PathVariable("newValue") int newValue) {
        Cart cartToUpdate = cartService.getCart(id);
        cartService.updateCart(cartToUpdate, newValue);
        return "redirect:cart";
    }

    @DeleteMapping("/cart/{cartId}")
    public String deleteCart(@PathVariable("cartId") Long id) {
        Cart cartToDelete = cartService.getCart(id);
        cartService.deleteCart(cartToDelete);
        return "redirect:newCart";
    }

}
