package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Product;
import com.intentsg.shop.repository.ProductRepository;
import com.intentsg.shop.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = ProductServiceImpl.class)
class ProductServiceTest {

    private static final long EXPECTED_ID = 1L;
    private static final Object EXPECTED_CLASS = Product.class;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void testCreateProduct() {
        Product fakeProduct = new Product();
        fakeProduct.setId(EXPECTED_ID);
        given(productRepository.save(any())).willReturn(fakeProduct);

        Product actualCart = productService.createProduct(fakeProduct);

        assertEquals(fakeProduct.getId(), actualCart.getId());
    }

    @Test
    void testUpdateProduct() {
        Product productToUpdate = new Product();

        productService.updateProduct(productToUpdate);

        verify(productRepository).save(eq(productToUpdate));
    }

    @Test
    void testGetProduct() {
        Product productToGet;
        Product fakeProduct = new Product();
        given(productRepository.findById(eq(EXPECTED_ID))).willReturn(Optional.of(fakeProduct));

        productToGet = productService.getProduct(EXPECTED_ID);
        verify(productRepository).findById(eq(EXPECTED_ID));

        assertEquals(EXPECTED_CLASS, productToGet.getClass());
    }

    @Test
    void testDeleteProduct() {
        Product productToDelete = new Product();

        productService.deleteProduct(productToDelete);

        verify(productRepository).delete(eq(productToDelete));
    }

}
