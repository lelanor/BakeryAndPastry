package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DAO.ProductDAO;
import com.elofaro.bakeryandpastry.DTO.CatalogDTO;
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

    public CatalogController(@Autowired ProductDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String catalogDisplay(Model model) {
        List<Product> products = createProductList();
        model.addAttribute("products", products);
        model.addAttribute("catalogForm", new CatalogDTO());
        return "catalogTemplate";
    }

    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        dao.findAll().forEach(productList::add);
        return productList;
    }

    @PostMapping
    public String CartUpdate(@ModelAttribute CatalogDTO catalogForm, Model model, HttpSession session) {

        List<Product> productList = createProductList();
        model.addAttribute("products", productList);

        List<String> orderedProducts = getProductsFromSession(session);

        for (int i = 0; i < catalogForm.getProductQuantity(); i++) {
            orderedProducts.add(catalogForm.getProductName());
        }

        session.setAttribute("totalInCart", orderedProducts.size());
        session.setAttribute("orderedProducts", orderedProducts);
        model.addAttribute("catalogForm", new CatalogDTO());
        return "catalogTemplate";
    }

    private List<String> getProductsFromSession(HttpSession session) {
        List<String> result = (ArrayList<String>) (session.getAttribute("orderedProducts"));
        if(result == null) {
            result = new ArrayList<>();
        }
        return result;
    }
}
