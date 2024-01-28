package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.adapter.AccountAdaptor;
import com.nhnacademy.gateway.dto.account.LoginRequest;
import com.nhnacademy.gateway.dto.account.UserAuthDto;
import com.nhnacademy.gateway.dto.account.UserModifyRequest;
import com.nhnacademy.gateway.dto.account.UserRegisterRequest;
import com.nhnacademy.gateway.dto.account.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
//@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountAdaptor accountAdaptor;

    @GetMapping("/accounts/{id}")
    public String getAccount(@PathVariable("id") String userId, Model model) {

        UserResponse userResponse = accountAdaptor.getAccount(userId);
        model.addAttribute("account", userResponse);

        return "/account/home";
    }

    @PostMapping("/accounts/{id}")
    public String createAccount(@RequestBody UserRegisterRequest userRegisterRequest) {
        accountAdaptor.createAccount(userRegisterRequest);
        return "/account/loginForm";
    }

    @DeleteMapping("/accounts/{id}")
    public String deleteAccount(@PathVariable("id") String userId) {
        accountAdaptor.deleteAccount(userId);
        return "/account/loginForm";
    }

    @PutMapping("/accunts/{id}")
    public String updateAccount(@RequestBody UserModifyRequest userModifyRequest) {
        accountAdaptor.modifyAccount(userModifyRequest);
        return "/account/userModifyForm";
    }

    public String matchesAccount(@RequestBody LoginRequest loginRequest) {

        UserAuthDto userAuthDto = accountAdaptor.matchesAccount(loginRequest);

        if (userAuthDto.isLoginUser()) {
            return "/account/home";
        } else {
            return "redirect:/account/loginForm";
        }
    }

}
