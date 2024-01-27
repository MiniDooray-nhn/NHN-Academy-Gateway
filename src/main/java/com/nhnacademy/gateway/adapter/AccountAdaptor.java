package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.config.AccountAdaptorProperties;
import com.nhnacademy.gateway.dto.account.UserAuthDto;
import com.nhnacademy.gateway.dto.account.UserModifyRequest;
import com.nhnacademy.gateway.dto.account.UserRegisterRequest;
import com.nhnacademy.gateway.dto.account.UserResponse;
import com.nhnacademy.gateway.dto.task.Account;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AccountAdaptor {
    private final RestTemplate restTemplate;
    private final AccountAdaptorProperties accountAdaptorProperties;

    public List<Account> getAccounts(String userId) {
        ResponseEntity<List<Account>> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }

    public UserResponse getAccount(String userId) {
        ResponseEntity<UserResponse>
                responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/" + userId, HttpMethod.GET,
                        null, new ParameterizedTypeReference<>() {
                        }, userId);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }

        return responseEntity.getBody();
    }

    public void createAccount(UserRegisterRequest userRegisterRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserRegisterRequest> requestHttpEntity = new HttpEntity<>(userRegisterRequest, headers);
        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.POST, requestHttpEntity,
                        new ParameterizedTypeReference<>() {
                        });

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
    }

    public void modifyAccount(UserModifyRequest userModifyRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserModifyRequest> requestHttpEntity = new HttpEntity<>(userModifyRequest, headers);
        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.PUT, null,
                        new ParameterizedTypeReference<>() {
                        });

        if(responseEntity.getStatusCode() != HttpStatus.OK){
            throw new RuntimeException();
        }
    }

    public void deleteAccount(String userId){

        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {
                        });

        if(responseEntity.getStatusCode() != HttpStatus.OK){
            throw new RuntimeException();
        }
    }

    public boolean matchesAccount(UserAuthDto userAuthDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserAuthDto> userAuthDtoHttpEntity = new HttpEntity<>(userAuthDto, headers);
        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.POST, null,
                        new ParameterizedTypeReference<>() {
                        });

        return responseEntity.getStatusCode().is2xxSuccessful(); // 성공 요청 판단

    }

}
