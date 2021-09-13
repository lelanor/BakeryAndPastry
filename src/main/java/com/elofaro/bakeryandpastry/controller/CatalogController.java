package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.dao.ProductDAO;
import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    private ProductDAO dao;

    public CatalogController(@Autowired ProductDAO dao){
        this.dao = dao;
    }

    @GetMapping
    public String catalogDisplay(Model model) {

        List<Product> productList = new ArrayList<>();
        for (Product product: dao.findAll()) {
            productList.add(product);
        }

        model.addAttribute("produits", productList);
        return "catalogTemplate";
    }

}
