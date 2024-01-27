package com.nhnacademy.gateway.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {


    String id;

    String password;

    String email;

    String name;


}
