package com.elofaro.bakeryandpastry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/orderCheck")
public class OrderCheckController {

    @GetMapping
    public String showOrder(Model model, HttpSession session){
        return "orderCheckTemplate";
    }
}
