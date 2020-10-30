package com.intentsg.shop.services;

import com.intentsg.shop.models.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
