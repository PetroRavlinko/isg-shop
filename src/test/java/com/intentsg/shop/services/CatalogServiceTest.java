package com.intentsg.shop.services;

import com.intentsg.shop.models.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        // Given
        Catalog catalogToSave = new Catalog();
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);
        given(catalogRepository.saveCatalog(eq(catalogToSave))).willReturn(fakeCatalog);

        // When
        Catalog actualCatalog = catalogService.createCatalog(catalogToSave);

        // Then
        verify(catalogRepository).saveCatalog(eq(catalogToSave));
        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }

    @Test
    void testGetCatalog() {
        // Given
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);
        given(catalogRepository.get(eq(EXPECTED_CATALOG_ID))).willReturn(fakeCatalog);

        // When
        Catalog actualCatalog = catalogRepository.get(EXPECTED_CATALOG_ID);

        // Then
        verify(catalogRepository).get(eq(EXPECTED_CATALOG_ID));
        assertEquals(fakeCatalog, actualCatalog);
    }

    @Test
    void restDeleteCatalog() {
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);

        given(catalogRepository.deleteCatalog(eq(fakeCatalog))).willReturn(fakeCatalog);

        Catalog actualCatalog = catalogService.delete(fakeCatalog);

        verify(catalogRepository).delete(eq(fakeCatalog));
        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }

    @Test
    void testUpdateCatalog() {
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);
        fakeCatalog.setTitle("cat1");

        Catalog catalogToUpdate = new Catalog();
        catalogToUpdate.setId(EXPECTED_CATALOG_ID);
        catalogToUpdate.setTitle("cat2");

        given(catalogRepository.update(eq(catalogToUpdate))).willReturn(catalogToUpdate);

        Catalog savedCatalog = catalogRepository.saveCatalog(fakeCatalog);
        Catalog actualCatalog = catalogRepository.update(catalogToUpdate);

        verify(catalogRepository).update(eq(catalogToUpdate));
        assertEquals("cat2", actualCatalog.getTitle());
        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }
}