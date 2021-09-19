package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DAO.AccountDAO;
import com.elofaro.bakeryandpastry.DAO.CustomerDetailDAO;
import com.elofaro.bakeryandpastry.DTO.SignupDTO;
import com.elofaro.bakeryandpastry.model.Account;
import com.elofaro.bakeryandpastry.model.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
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

    public SignupController(@Autowired AccountDAO accountDAO, @Autowired CustomerDetailDAO customerDetailDAO){
        this.accountDAO = accountDAO;
        this.customerDetailDAO = customerDetailDAO;
    }

    @GetMapping
    public String showSignUp(Model model) {
        model.addAttribute("signupForm", new SignupDTO());
        return "signupTemplate";
    }

    @PostMapping
    public String processSignupForm(@ModelAttribute SignupDTO signupDTO, Model model, HttpSession session) {
        /*String password;
        if (check(signupDTO.getPassword())) {
            password = encrypt(signupDTO.getPassword());
        } else return "signupTemplate";*/

        saveInDatabase(signupDTO);

        return "landingTemplate";
    }

    private void saveInDatabase(SignupDTO signupDTO) {
        Account account = new Account(signupDTO.getEmail(), signupDTO.getPassword());
        accountDAO.save(account);
        CustomerDetail customerDetail = new CustomerDetail(signupDTO.getFirstname(), signupDTO.getLastname(), signupDTO.getAddress());
        customerDetailDAO.save(customerDetail);
    }

    private String encrypt(String clearPassword){
        String result = null;

        return result;
    }

    private boolean check(String password){
        return true;
    }
}
