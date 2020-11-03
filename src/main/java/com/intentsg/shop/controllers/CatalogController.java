package com.intentsg.shop.controllers;

import com.intentsg.shop.dto.CatalogDTO;
import com.intentsg.shop.model.Catalog;
import com.intentsg.shop.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public ResponseEntity<Catalog> getCatalog( @PathParam( "id" ) Long id) {
        return new ResponseEntity<>( catalogService.getCatalogById( id ), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Catalog> createCatalog( @RequestBody CatalogDTO catalogDTO ){
        Catalog catalog = new Catalog();
        catalog.setTitle( catalogDTO.getTitle() );
        return new ResponseEntity<>( catalogService.createCatalog( catalog ), HttpStatus.CREATED );
    }

    @DeleteMapping
    public ResponseEntity<Catalog> deleteCatalogById(@PathParam( "id" ) Long id) {
        Catalog catalog = catalogService.getCatalogById( id );
        catalogService.deleteCatalog( catalog );
        return new ResponseEntity<>( catalog, HttpStatus.OK );
    }
    @PutMapping
    public ResponseEntity<Catalog> updateCatalog(@RequestBody CatalogDTO catalogDTO ){
        Catalog catalog = new Catalog();
        catalog.setTitle( catalogDTO.getTitle() );
        catalog.setId(catalogDTO.getId());
        return new ResponseEntity<>( catalogService.createCatalog( catalog ), HttpStatus.CREATED );
    }
}
