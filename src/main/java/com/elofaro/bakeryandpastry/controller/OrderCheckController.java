package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DTO.OrderDTO;
import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/orderCheck")
public class OrderCheckController {

    List<OrderDTO> order = new ArrayList<>();

    @GetMapping
    public String showOrder(Model model, HttpSession session) {
        List<Product> unsortedList = (List<Product>) session.getAttribute("orderedProducts");
        Set<Product> orderedProducts = new HashSet<>(unsortedList);
        double totalOrder = 0;
        for (Product element :
                orderedProducts) {
            order.add(new OrderDTO(element, Collections.frequency(unsortedList, element)));
        }
        for (OrderDTO element :
                order) {
            totalOrder += element.totalAmount();
        }

        session.setAttribute("order", order);
        session.setAttribute("total", totalOrder);
        return "orderCheckTemplate";
    }
}
