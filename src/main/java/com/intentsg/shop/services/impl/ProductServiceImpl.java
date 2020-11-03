package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.model.Product;
import com.intentsg.shop.repository.ProductRepository;
import com.intentsg.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private Product currentProduct;

    @PostConstruct
    public void initiate() {
        this.currentProduct = this.createProduct();
    }

    @Override
    public Product createProduct() {
        return productRepository.save(new Product());
    }

    @Override
    public Product getCurrentProduct() {
        return this.currentProduct;
    }

    @Override
    public void updateProduct(Product product){ productRepository.save(product); }

    @Override
    public void deleteProduct(Product productToDelete) { productRepository.delete(productToDelete); }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElseThrow();
    }
}