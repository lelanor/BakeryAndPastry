package com.elofaro.bakeryandpastry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @GetMapping
    public String showCheckout(Model model){
        return "checkoutTemplate";
    }
}
