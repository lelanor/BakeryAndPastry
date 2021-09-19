package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DAO.ProductDAO;
import com.elofaro.bakeryandpastry.DTO.OrderDTO;
import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.function.BiFunction;

@Controller
@RequestMapping("/orderCheck")
public class OrderCheckController {

    private final ProductDAO dao;

    public OrderCheckController(@Autowired ProductDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String showOrder(Model model, HttpSession session) {
        List<Product> products = getProductsFromSession(session);
        List<OrderDTO> order = buildOrder(products);
        double totalAmount = getTotalAmount(order);

        session.setAttribute("order", order);
        session.setAttribute("total", totalAmount);
        return "orderCheckTemplate";
    }

    private List<Product> getProductsFromSession(HttpSession session) {
        List<String> labels = (ArrayList<String>) (session.getAttribute("orderedProducts"));
        if(labels == null) {
            labels = new ArrayList<>();
        }
        return labels.stream().map(dao::findByLabel).toList();
    }

    private List<OrderDTO> buildOrder(List<Product> products) {
        Map<Product, Integer> m = buildFrequencies(products);

        List<OrderDTO> result = new ArrayList<>();
        m.forEach((key, value) -> result.add(new OrderDTO(key, value)));
        return result;
    }

    private Map<Product, Integer> buildFrequencies(List<Product> products) {
        Map<Product, Integer> result = new HashMap<Product, Integer>();
        products.forEach(p -> result.merge(p, 1, Integer::sum));
        return result;
    }

    private Double getTotalAmount(List<OrderDTO> order){
        return order.stream().mapToDouble(OrderDTO::totalAmount).sum();
    }
}
