package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DAO.AccountDAO;
import com.elofaro.bakeryandpastry.DAO.CustomerDetailDAO;
import com.elofaro.bakeryandpastry.DTO.SignupDTO;
import com.elofaro.bakeryandpastry.model.Account;
import com.elofaro.bakeryandpastry.model.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signup")
public class SignupController {

    AccountDAO accountDAO;
    CustomerDetailDAO customerDetailDAO;
    PasswordEncoder passwordEncoder;

    public SignupController(@Autowired AccountDAO accountDAO, @Autowired CustomerDetailDAO customerDetailDAO,
                            @Autowired PasswordEncoder passwordEncoder) {
        this.accountDAO = accountDAO;
        this.customerDetailDAO = customerDetailDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showSignUp(Model model) {
        model.addAttribute("signupForm", new SignupDTO());
        return "signupTemplate";
    }

    @PostMapping
    public String processSignupForm(@ModelAttribute SignupDTO signupDTO, HttpSession session) {
        saveInDatabase(signupDTO);
        saveInSession(signupDTO, session);
        return "landingTemplate";
    }

    private void saveInSession(SignupDTO signupDTO, HttpSession session) {
        session.setAttribute("email", signupDTO.getEmail());
        session.setAttribute("firstname", signupDTO.getFirstname());
        session.setAttribute("lastname", signupDTO.getLastname());
        session.setAttribute("address", signupDTO.getAddress());
    }

    private void saveInDatabase(SignupDTO signupDTO) {
        Account account = new Account(signupDTO.getEmail(), encryptPassword(signupDTO.getPassword()));
        accountDAO.save(account);
        CustomerDetail customerDetail = new CustomerDetail(signupDTO.getFirstname(), signupDTO.getLastname(), signupDTO.getAddress());
        customerDetailDAO.save(customerDetail);
    }

    private String encryptPassword(String passwordToEncrypt) {
        return passwordEncoder.encode(passwordToEncrypt);
    }
}
