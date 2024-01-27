package com.nhnacademy.gateway.dto.account;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    String id;

    String password;

    String email;

    String name;

    LocalDateTime createdAt;

}
