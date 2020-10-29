package com.intentsg.shop.repository;

import com.intentsg.shop.models.Product;

public interface ProductRepository {
    Product saveProduct(Product product);
    Product deleteProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Product product);

}
