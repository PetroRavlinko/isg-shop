package com.intentsg.shop.repositories;

import com.intentsg.shop.models.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import com.intentsg.shop.repository.DefaultCatalogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = DefaultCatalogRepository.class)
public class CatalogRepositoryTest {
    @Autowired
    private CatalogRepository repository;

    @Test
    void saveGetUpdateCatalogTest() {
        Catalog catalog = new Catalog();
        Catalog savedCatalog = repository.saveCatalog(catalog);
        Catalog gotCatalog = repository.getCatalogById(savedCatalog.getId());
        Catalog catalogToUpdate = new Catalog();
        catalogToUpdate.setId(catalog.getId());
        catalogToUpdate.setTitle("Updated value");
        repository.updateCatalog(catalogToUpdate);

        assertEquals(catalog, savedCatalog);
        assertEquals(catalog, gotCatalog);
        assertEquals("Updated value", repository.getCatalogById(catalog.getId()).getTitle());
    }

    @Test
    void removeCatalogTest(){
        Catalog catalog = new Catalog();
        repository.saveCatalog(catalog);
        repository.deleteCatalog(catalog);
        assertNotEquals(catalog, repository.getCatalogById(catalog.getId()));
    }

}
