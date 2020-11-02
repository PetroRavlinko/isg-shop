package com.intentsg.shop.controllers;

import com.intentsg.shop.DTO.CatalogDTO;
import com.intentsg.shop.model.Catalog;
import com.intentsg.shop.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    private static final String ATTRIBUTE = "catalog";

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public String getCatalog(@PathParam( "id" ) Long id, Model model) {
        model.addAttribute(ATTRIBUTE, catalogService.getCatalogById(id));
        return ATTRIBUTE;
    }

    @PostMapping
    public String createCatalog( @RequestBody CatalogDTO catalogDTO, Model model ){
        Catalog newCatalog = new Catalog();
        newCatalog.setTitle( catalogDTO.getTitle() );
        catalogService.createCatalog( newCatalog );
        model.addAttribute( ATTRIBUTE, catalogService.getCatalogById( newCatalog.getId() ) );
        return ATTRIBUTE;
    }

    @DeleteMapping
    public void deleteCatalog(@PathParam( "id" ) Long id, Model model){
        Catalog catalogToDelete = catalogService.getCatalogById(id);
        catalogService.deleteCatalog(catalogToDelete);
    }

}
