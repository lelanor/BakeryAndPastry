package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DAO.ProductDAO;
import com.elofaro.bakeryandpastry.DTO.CatalogForm;
import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    private ProductDAO dao;
    private List<Product> orderedProducts = new ArrayList<>();

    public CatalogController(@Autowired ProductDAO dao) {
        this.dao = dao;
    }


    @GetMapping
    public String catalogDisplay(Model model) {
        List<Product> productList = new ArrayList<>();
        createProductList(productList);
        model.addAttribute("products", productList);
        model.addAttribute("catalogForm", new CatalogForm());
        return "catalogTemplate";
    }

    private void createProductList(List<Product> productList) {
        for (Product product : dao.findAll()) {
            productList.add(product);
        }
    }

    @PostMapping
    public String CartUpdate(@ModelAttribute CatalogForm catalogForm, Model model, HttpSession session) {

        List<Product> productList = new ArrayList<>();
        createProductList(productList);
        model.addAttribute("products", productList);

        Product orderedProduct = dao.findByLabel(catalogForm.getProductName());
        Integer orderedQuantity = catalogForm.getProductQuantity();

        for (int i = 0; i < orderedQuantity; i++) {
            orderedProducts.add(orderedProduct);
        }

        session.setAttribute("totalInCart", orderedProducts.size());
        session.setAttribute("orderedProducts", orderedProducts);
        model.addAttribute("catalogForm", new CatalogForm());
        return "catalogTemplate";
    }

}
