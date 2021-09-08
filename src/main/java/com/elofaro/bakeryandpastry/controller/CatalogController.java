package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.model.Produit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    @GetMapping
    public String catalogDisplay(Model model){
        Produit produit1 = new Produit("Baguette tropezienne",10.00,"Thymeleaf ","images/baguette_tropezienne_200x133.jpg");
        Produit produit2 = new Produit("Croissants",5.00,"Thymeleaf croissants","images/croissants_200x133.jpg");
        Produit produit3 = new Produit("Pastries variety box",20.00,"Thymeleaf pastries","images/pastry_variety_box_200x133.jpg");
        Produit produit4 = new Produit("Confitures",7.00,"Thymeleaf confitures", "images/confitures_200x133.jpg");
        List<Produit> produitList = new ArrayList<>();
        produitList.add(produit1);
        produitList.add(produit2);
        produitList.add(produit3);
        produitList.add(produit4);
/*
        Produit[] produits = produitList.toArray();
*/

        model.addAttribute("produits", produitList);
        return "catalogTemplate";
    }

}
