package com.nhnacademy.gateway.domain;

import java.util.Date;
import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Account {

    private String userId;

    private String userPassword;

    private String email;

    private String name;

    private String status;

    private Date createdAt;


}
