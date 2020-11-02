package com.intentsg.shop.services;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.model.Product;

public interface ProductService {

    Product getCurrentProduct();
    Product createProduct();
    void updateProduct(Product product);
    void deleteProduct(Product productToDelete);
    Product getProduct(long id);

}