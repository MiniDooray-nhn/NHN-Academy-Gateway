package com.nhnacademy.gateway.request.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreateRequest {

    @NotBlank
    private String userId;


    @NotBlank
    private String userPassword;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

}
