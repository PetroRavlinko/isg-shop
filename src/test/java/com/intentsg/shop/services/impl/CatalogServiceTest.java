package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import com.intentsg.shop.services.impl.CatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

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

        assertEquals(EXPECTED_CATALOG_ID, actualCatalog.getId());
    }

    @Test
    void testGetCatalog() {
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);
        given(catalogRepository.findById(eq(EXPECTED_CATALOG_ID))).willReturn(Optional.of(fakeCatalog));

        Catalog actualCatalog = catalogService.getCatalogById(EXPECTED_CATALOG_ID);

        assertEquals(fakeCatalog, actualCatalog);
    }

    @Test
    void restDeleteCatalog() {
        Catalog fakeCatalog = new Catalog();
        fakeCatalog.setId(EXPECTED_CATALOG_ID);

        given(catalogRepository.save(eq(fakeCatalog))).willReturn(fakeCatalog);
        Catalog actualCatalog = catalogRepository.save(fakeCatalog);

        catalogService.deleteCatalog(fakeCatalog);

        assertEquals(fakeCatalog, actualCatalog);
    }
}