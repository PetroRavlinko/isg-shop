package com.intentsg.shop.repositories;

import com.intentsg.shop.models.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = CatalogRepository.class)
public class CatalogRepositoryTest {
    @Autowired
    private CatalogRepository repository;

    @Test
    void saveGetUpdateCatalogTest() {
        Catalog catalog = new Catalog();
        Catalog savedCatalog = repository.save(catalog);
        Catalog gotCatalog = repository.findById(savedCatalog.getId()).get();
        Catalog catalogToUpdate = new Catalog();
        catalogToUpdate.setId(catalog.getId());
        catalogToUpdate.setTitle("Updated value");
        repository.save(catalogToUpdate);

        assertEquals(catalog, savedCatalog);
        assertEquals(catalog, gotCatalog);
        assertEquals("Updated value", repository.findById(catalog.getId()).get().getTitle());
    }

    @Test
    void removeCatalogTest(){
        Catalog catalog = new Catalog();
        repository.save(catalog);
        repository.delete(catalog);
        assertNotEquals(catalog, repository.findById(catalog.getId()).get());
    }

}
