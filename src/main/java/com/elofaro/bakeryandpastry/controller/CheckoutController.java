package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DTO.CheckOutDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @GetMapping
    public String showCheckout(Model model, HttpSession session) {
        CheckOutDTO checkOutDTO = new CheckOutDTO();
        if (session.getId() != null) {
            checkOutDTO.setFirstname((String) session.getAttribute("firstname"));
            checkOutDTO.setFirstname((String)session.getAttribute("lastname"));
            checkOutDTO.setFirstname((String)session.getAttribute("email"));
            checkOutDTO.setFirstname((String)session.getAttribute("address"));
        }
        model.addAttribute("dto", checkOutDTO);
        return "checkoutTemplate";
    }
}
