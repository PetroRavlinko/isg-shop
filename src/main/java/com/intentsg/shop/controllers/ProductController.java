package com.intentsg.shop.controllers;

import com.intentsg.shop.dto.ProductDto;
import com.intentsg.shop.model.Product;
import com.intentsg.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Product> getProduct( @PathParam( "id" ) Long id) {
        return new ResponseEntity<>( productService.getProduct( id ), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Product> createProduct( @RequestBody ProductDto productDto ){
        Product product = new Product();
        product.setTitle( productDto.getTitle() );
        return new ResponseEntity<>( productService.createProduct( product ), HttpStatus.CREATED );
    }

    @DeleteMapping
    public ResponseEntity<Product> deleteProductById(@PathParam( "id" ) Long id) {
        Product product = productService.getProduct( id );
        productService.deleteProduct( product );
        return new ResponseEntity<>( product, HttpStatus.OK );
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto ){
        Product product = new Product();
        product.setTitle( productDto.getTitle() );
        product.setId(productDto.getId());
        return new ResponseEntity<>( productService.createProduct( product ), HttpStatus.CREATED );
    }
}