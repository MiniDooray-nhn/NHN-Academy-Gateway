package com.nhnacademy.gateway.config;


import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "account.api.server")
@Data
public class AccountAdaptorProperties {
    @NotNull
    private String address;
}

