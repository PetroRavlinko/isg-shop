package com.intentsg.shop.services;

import com.intentsg.shop.models.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = CatalogService.class)
class CatalogServiceTest {
    private static final long EXPECTED_CATALOG_ID = 1L;

    @MockBean
    private CatalogRepository catalogRepository;

    @Autowired
    private CatalogService catalogService;

    @Test
    void testCreateCatalog() {
        Catalog catalogToSave = new Catalog();
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);
        given(catalogRepository.save(eq(catalogToSave))).willReturn(fakeCatalog);

        Catalog actualCatalog = catalogService.createCatalog(catalogToSave);

        verify(catalogRepository).saveCatalog(eq(catalogToSave));

        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }

    @Test
    void testGetCatalog() {
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);
        given(catalogRepository.getCatalogById(eq(EXPECTED_CATALOG_ID))).willReturn(fakeCatalog);

        Catalog actualCatalog = catalogService.getCatalogById(EXPECTED_CATALOG_ID);

        verify(catalogRepository).getCatalogById(eq(EXPECTED_CATALOG_ID));

        assertEquals(fakeCatalog, actualCatalog);
    }

    @Test
    void restDeleteCatalog() {
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);

        given(catalogRepository.deleteCatalog(eq(fakeCatalog))).willReturn(fakeCatalog);

        Catalog actualCatalog = catalogService.deleteCatalog(fakeCatalog);

        verify(catalogRepository).deleteCatalog(eq(fakeCatalog));

        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }

    @Test
    void testUpdateCatalog() {
        Catalog catalogToUpdate = new Catalog();
        catalogToUpdate.setId(EXPECTED_CATALOG_ID);
        catalogToUpdate.setTitle("cat2");

        given(catalogRepository.updateCatalog(eq(catalogToUpdate))).willReturn(catalogToUpdate);

        Catalog actualCatalog = catalogService.updateCatalog(catalogToUpdate);

        verify(catalogRepository).updateCatalog(eq(catalogToUpdate));

        assertEquals("cat2", actualCatalog.getTitle());
        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }
}