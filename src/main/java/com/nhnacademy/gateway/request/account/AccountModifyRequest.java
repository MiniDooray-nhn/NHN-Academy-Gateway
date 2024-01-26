package com.nhnacademy.gateway.request.account;


import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountModifyRequest {


    @NotBlank
    private String userPassword;

    @NotBlank
    private String email;

    @NotBlank
    private String name;
}
