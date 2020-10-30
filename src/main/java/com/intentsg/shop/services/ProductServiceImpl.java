package com.intentsg.shop.services;

import com.intentsg.shop.model.Product;
import com.intentsg.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct() {
        return productRepository.save(new Product());
    }

    @Override
    public void updateProduct(Product product){
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product productToDelete) {
        productRepository.delete(productToDelete);
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElseThrow();
    }
}