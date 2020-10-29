package com.intentsg.shop.repository;

import com.intentsg.shop.models.Catalog;

public interface CatalogRepository {
    Catalog saveCatalog(Catalog catalog);
    Catalog deleteCatalog(Catalog catalog);
    Catalog updateCatalog(Catalog catalog);
    Catalog getCatalogById(Long id);
}
