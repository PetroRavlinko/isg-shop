package com.intentsg.shop.repository;

import com.intentsg.shop.models.Catalog;

public interface CatalogRepository {
    Catalog saveCatalog(Catalog catalog);
    Catalog delete(Catalog catalog);
    Catalog update(Catalog catalog);
    Catalog get(Long id);
}
