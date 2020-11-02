package com.intentsg.shop.controllers;

import com.intentsg.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String getProduct(Model model) {
        model.addAttribute("product", productService.getCurrentProduct());
        return "product";
    }

}
