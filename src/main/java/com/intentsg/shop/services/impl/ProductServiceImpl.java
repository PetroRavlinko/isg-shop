package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Product;
import com.intentsg.shop.repository.ProductRepository;
import com.intentsg.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private Product currentProduct;

    @PostConstruct
    public void initiate() {
        this.currentProduct = this.createProduct(new Product());
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save( product );
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