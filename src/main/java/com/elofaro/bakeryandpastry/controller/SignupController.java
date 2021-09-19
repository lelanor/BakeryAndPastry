package com.elofaro.bakeryandpastry.controller;

import com.elofaro.bakeryandpastry.DTO.SignupDTO;
import com.elofaro.bakeryandpastry.model.Account;
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

    @GetMapping
    public String showSignUp(Model model) {
        model.addAttribute("signupForm", new SignupDTO());
        return "signupTemplate";
    }

    @PostMapping
    public String processSignupForm(@ModelAttribute SignupDTO signupDTO, Model model, HttpSession session) {
        String password;
        if (check(signupDTO.getPassword())) {
            password = encrypt(signupDTO.getPassword());
        } else return "signupTemplate";

        Account account = new Account(signupDTO.getEmail(), password);
        return "";
    }

    private String encrypt(String clearPassword){
        String result = null;

        return result;
    }

    private boolean check(String password){
        return true;
    }
}
