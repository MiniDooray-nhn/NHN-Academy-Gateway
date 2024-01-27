package com.nhnacademy.gateway.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String userId;

    private String userPassword;

    private String email;

    private String name;

    private String status;

    private Date createdAt;


}
