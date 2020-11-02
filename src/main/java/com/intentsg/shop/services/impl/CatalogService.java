package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public Catalog createCatalog(Catalog catalogToSave) {
        return catalogRepository.save(catalogToSave);
    }

    public void deleteCatalog(Catalog catalogToDelete) {
        catalogRepository.delete(catalogToDelete);
    }

    public Catalog getCatalogById(Long id){
        return catalogRepository.findById(id).orElseThrow();
    }
}
