package com.intentsg.shop.services;

import com.intentsg.shop.model.Catalog;

public interface CatalogService {
    Catalog createCatalog(Catalog newCatalog);
    void deleteCatalog(Catalog catalog);
    Catalog getCatalogById(Long id);
}
