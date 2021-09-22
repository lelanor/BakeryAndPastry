package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DAO.ProductDAO;
import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LandingController {

    ProductDAO dao;

    public LandingController(@Autowired ProductDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String displayIndex(Model model, HttpSession session) {

        if(!session.isNew()) {
            session.removeAttribute("order");
        }

        List<Product> products = getProducts();
        model.addAttribute("products", products);
        return "landingTemplate";
    }

    private List<Product> getProducts(){
        List<Product> result = new ArrayList<>();
        dao.findAll().forEach(result::add);
        return result;
    }
}
