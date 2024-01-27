package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.config.AccountAdaptorProperties;
import com.nhnacademy.gateway.domain.Account;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AccountAdaptor {
    private final RestTemplate restTemplate;
    private final AccountAdaptorProperties accountAdaptorProperties;

    public List<Account> getAccounts() {
        ResponseEntity<List<Account>> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress()+"/accounts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        if(exchange.getStatusCode() != HttpStatus.OK){
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
