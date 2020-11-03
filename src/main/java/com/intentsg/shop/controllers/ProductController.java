package com.intentsg.shop.controllers;

import com.intentsg.shop.dto.ProductDto;
import com.intentsg.shop.model.Product;
import com.intentsg.shop.services.ProductService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getProduct(Model model) {
        model.addAttribute("product", productService.getCurrentProduct());
        return "product";
    }

    @GetMapping("/products/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }

    @PostMapping("/products")
    public String createProduct(Model model, @RequestBody ProductDto  productDto) {
        Product product = productService.createProduct();
        product.setTitle(productDto.getTitle());
        productService.updateProduct(product);
        model.addAttribute("product", product);
        return "product";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(Model model, @PathVariable  Long id) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        productService.deleteProduct(productService.getProduct(id));
        return "product";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(Model model, @RequestBody ProductDto  productDto, @PathVariable  Long id) {
        Product product = productService.getProduct(id);
        product.setTitle(productDto.getTitle());
        productService.updateProduct(product);
        model.addAttribute("product", product);
        return "product";
    }

}
