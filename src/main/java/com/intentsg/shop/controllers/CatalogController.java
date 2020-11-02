package com.intentsg.shop.controllers;

import com.intentsg.shop.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
