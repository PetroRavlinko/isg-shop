package com.intentsg.shop.services;

import com.intentsg.shop.models.Product;
import com.intentsg.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private  final ProductRepository productRepository;

    public Product createProduct(Product productToSave){
        return productRepository.saveProduct(productToSave);
    }

    public Product deleteProduct(Product productToDelete){
        return productRepository.deleteProduct(productToDelete);
    }

    public Product updateProduct(Product productToUpdate){
        return productRepository.updateProduct(productToUpdate);
    }

    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }
}
