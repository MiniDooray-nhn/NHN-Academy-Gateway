package com.nhnacademy.gateway.adator;

import com.nhnacademy.gateway.config.AccountAdaptorProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountAdaptorImpl implements AccountAdaptor {

    private final RestTemplate restTemplate;
    private final AccountAdaptorProperties accountAdaptorProperties;

    public AccountAdaptorImpl(RestTemplate restTemplate,
                              AccountAdaptorProperties accountAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.accountAdaptorProperties = accountAdaptorProperties;
    }

}
