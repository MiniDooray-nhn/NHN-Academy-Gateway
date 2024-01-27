package com.nhnacademy.gateway.config;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "task.api.server")
@Data
public class TaskAdaptorProperties {
    @NotNull
    private String address;
}
