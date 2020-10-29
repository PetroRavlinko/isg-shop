package com.intentsg.shop.repository;

import com.intentsg.shop.models.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DefaultCatalogRepository implements CatalogRepository {
    private final List<Catalog> repository = new ArrayList<>();

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        catalog.setId(Integer.toUnsignedLong(repository.size()));
        repository.add(catalog);
        return catalog;
    }

    @Override
    public Catalog deleteCatalog(Catalog catalog) {
        if (repository.remove(catalog))
            return catalog;
        else
            return null;
    }

    @Override
    public Catalog updateCatalog(Catalog catalog) {
        for (int i = 0; i < repository.size(); i++){
            if (repository.get(i).getId() == catalog.getId()) {
                repository.set(i, catalog);
            }
        }
        return catalog;
    }

    @Override
    public Catalog getCatalogById(Long id) {
        for(int i = 0; i < repository.size(); i++)
            if(repository.get(i).getId() == id ) return repository.get(i);
        return null;
    }


}
