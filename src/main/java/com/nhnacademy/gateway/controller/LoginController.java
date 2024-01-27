package com.nhnacademy.gateway.controller;


import com.nhnacademy.gateway.dto.account.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/loginForm")
    public String loginForm(LoginRequest loginRequest, Model model,
                            @RequestParam(required = false) String error) {
        model.addAttribute("loginRequest", loginRequest);
        model.addAttribute("error", error);

        return "account/loginForm";
    }
}
