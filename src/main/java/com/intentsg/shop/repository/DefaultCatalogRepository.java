package com.intentsg.shop.repository;

import com.intentsg.shop.models.Catalog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCatalogRepository implements CatalogRepository {
    private final List<Catalog> repository = new ArrayList<>();

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        catalog.setId(Integer.toUnsignedLong(repository.size()));
        repository.add(catalog);
        return catalog;
    }
}
