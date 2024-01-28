package com.nhnacademy.gateway.controller;


import com.nhnacademy.gateway.adapter.AccountAdaptor;
import com.nhnacademy.gateway.dto.account.LoginRequest;
import com.nhnacademy.gateway.dto.account.UserAuthDto;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AccountAdaptor accountAdaptor;

    public LoginController(AccountAdaptor accountAdaptor) {
        this.accountAdaptor = accountAdaptor;
    }

    @GetMapping("/login")
    public String loginForm(LoginRequest loginRequest, Model model,
                            @RequestParam(required = false) String error) {
        model.addAttribute("loginRequest", loginRequest);
        model.addAttribute("error", error);

        return "account/loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session) {

        UserAuthDto userAuthDto = accountAdaptor.matchesAccount(loginRequest);

        if (userAuthDto.isLoginUser()) {
            session.setAttribute("loginUser", loginRequest.getUserId());
            return "index";
        } else {
            return "redirect:/account/loginForm";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
