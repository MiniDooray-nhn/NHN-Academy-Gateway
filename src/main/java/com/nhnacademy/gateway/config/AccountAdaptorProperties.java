package com.nhnacademy.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhnacademy.account")
@Data
public class AccountAdaptorProperties {

    private String address;
}
