package com.intentsg.shop.controllers;

import com.intentsg.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", cartService.getCurrentCart());
        return "cart";
    }

}
