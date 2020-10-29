package com.intentsg.shop.repository;

import com.intentsg.shop.models.Product;
import com.intentsg.shop.repository.ProductRepository;
import com.intentsg.shop.repository.DefaultProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = DefaultProductRepository.class)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void saveGetUpdateCatalogTest() {
        Product product = new Product();
        Product savedProduct = repository.saveProduct(product);
        Product gotProduct = repository.getProductById(savedProduct.getId());
        Product productToUpdate = new Product();
        productToUpdate.setId(product.getId());
        productToUpdate.setTitle("Updated value");
        repository.updateProduct(productToUpdate);

        assertEquals(product, savedProduct);
        assertEquals(product, gotProduct);
        assertEquals("Updated value", repository.getProductById(product.getId()).getTitle());
    }

    @Test
    void removeProductTest(){
        Product product = new Product();
        repository.saveProduct(product);
        repository.deleteProduct(product);
        assertNotEquals(product, repository.getProductById(product.getId()));
    }

}