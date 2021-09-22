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
            checkOutDTO.setLastname((String)session.getAttribute("lastname"));
            checkOutDTO.setEmail((String)session.getAttribute("email"));
            checkOutDTO.setAddress((String)session.getAttribute("address"));
            System.out.println(checkOutDTO.getFirstname()+" "+checkOutDTO.getLastname()+
                    " "+checkOutDTO.getEmail()+" "+checkOutDTO.getAddress());
        }
        model.addAttribute("dto", checkOutDTO);
        return "checkoutTemplate";
    }
}
