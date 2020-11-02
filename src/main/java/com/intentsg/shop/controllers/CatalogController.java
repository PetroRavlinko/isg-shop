package com.intentsg.shop.controllers;

import com.intentsg.shop.services.CatalogService;
import com.intentsg.shop.services.impl.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/catalog")
    public String getCatalog( Model model) {
        model.addAttribute("catalog", catalogService.getCurrentCatalog());
        return "catalog";
    }

}
