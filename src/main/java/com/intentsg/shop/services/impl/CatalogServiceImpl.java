package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Catalog;
import com.intentsg.shop.repository.CatalogRepository;
import com.intentsg.shop.services.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    @Override
    public Catalog createCatalog( Catalog catalogToSave ) {
        return catalogRepository.save( catalogToSave );
    }

    @Override
    public void deleteCatalog( Catalog catalogToDelete ) {
        catalogRepository.delete( catalogToDelete );
    }

    @Override
    public Catalog getCatalogById( Long id ) {
        return catalogRepository.findById( id ).orElseThrow();
    }
}
