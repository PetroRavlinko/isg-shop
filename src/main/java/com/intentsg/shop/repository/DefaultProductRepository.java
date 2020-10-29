package com.intentsg.shop.repository;

import com.intentsg.shop.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultProductRepository implements ProductRepository{
    private final List<Product> repository = new ArrayList<>();

    @Override
    public Product saveProduct(Product product) {
        product.setId(Integer.toUnsignedLong(repository.size()));
        repository.add(product);
        return product;
    }

    @Override
    public Product deleteProduct(Product product) {
        if(repository.remove(product))
            return product;
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        for (int i = 0 ; i < repository.size(); i++){
            if(repository.get(i).getId() == id ){
                return repository.get(i);
            }
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        for(int i = 0; i < repository.size(); i++){
            if(repository.get(i).getId() == product.getId()) {
                repository.set(i, product);
            }
        }
        return product;
    }
}
