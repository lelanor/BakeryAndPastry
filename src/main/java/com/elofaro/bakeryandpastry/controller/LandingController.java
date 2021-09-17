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

        session.invalidate();

        List<Product> productList = new ArrayList<>();
        for (Product product : dao.findAll()) {
            productList.add(product);
        }

        model.addAttribute("products", productList);

        return "landingTemplate";
    }
}
