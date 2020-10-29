package com.intentsg.shop.services;

import com.intentsg.shop.models.Product;
import com.intentsg.shop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = ProductService.class)
class ProductServiceTest {
    private static final long EXPECTED_CATALOG_ID = 1L;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void testCreateProduct() {
        Product productToSave = new Product();
        Product fakeProduct = new Product();
        fakeProduct.setId(EXPECTED_CATALOG_ID);
        given(productRepository.saveProduct(eq(productToSave))).willReturn(fakeProduct);

        Product actualProduct = productService.createProduct(productToSave);

        verify(productRepository).saveProduct(eq(productToSave));

        assertEquals(EXPECTED_CATALOG_ID, actualProduct.getId());
    }

    @Test
    void testGetCatalog() {
        Product fakeProduct = new Product();
        fakeProduct.setId(EXPECTED_CATALOG_ID);
        given(productRepository.getProductById(eq(EXPECTED_CATALOG_ID))).willReturn(fakeProduct);

        Product actualProduct = productService.getProductById(EXPECTED_CATALOG_ID);

        verify(productRepository).getProductById(eq(EXPECTED_CATALOG_ID));

        assertEquals(fakeProduct, actualProduct);
    }

    @Test
    void restDeleteCatalog() {
        Product fakeProduct = new Product();
        fakeProduct.setId(EXPECTED_CATALOG_ID);

        Product productToDelete = productRepository.saveProduct(fakeProduct);

        given(productRepository.deleteProduct(eq(productToDelete))).willReturn(fakeProduct);

        Product actualProduct = productService.deleteProduct(productToDelete);

        verify(productRepository).deleteProduct(eq(productToDelete));

        assertEquals(EXPECTED_CATALOG_ID, actualProduct.getId());
    }

    @Test
    void testUpdateCatalog() {
        Product fakeProduct = new Product();
        fakeProduct.setId(EXPECTED_CATALOG_ID);
        fakeProduct.setTitle("product1");

        Product productToUpdate = new Product();
        productToUpdate.setId(EXPECTED_CATALOG_ID);
        productToUpdate.setTitle("product2");

        given(productRepository.updateProduct(eq(productToUpdate))).willReturn(productToUpdate);

        Product actualProduct = productService.updateProduct(productToUpdate);

        verify(productRepository).updateProduct(eq(productToUpdate));

        assertEquals("product2", actualProduct.getTitle());
        assertEquals(EXPECTED_CATALOG_ID, actualProduct.getId());
    }
    @Test
    void testProduct(){

    }
}