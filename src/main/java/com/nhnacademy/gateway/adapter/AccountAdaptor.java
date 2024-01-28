package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.config.AccountAdaptorProperties;
import com.nhnacademy.gateway.dto.account.DeleteResponse;
import com.nhnacademy.gateway.dto.account.LoginRequest;
import com.nhnacademy.gateway.dto.account.UserAuthDto;
import com.nhnacademy.gateway.dto.account.UserModifyRequest;
import com.nhnacademy.gateway.dto.account.UserRegisterRequest;
import com.nhnacademy.gateway.dto.account.UserResponse;
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

    public List<UserResponse> getAccounts(String userId) {
        ResponseEntity<List<UserResponse>> responseEntity =
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

    public UserResponse createAccount(UserRegisterRequest userRegisterRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserRegisterRequest> requestHttpEntity = new HttpEntity<>(userRegisterRequest, headers);
        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.POST,
                        requestHttpEntity,
                        new ParameterizedTypeReference<>() {
                        });

        if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }

    public UserResponse modifyAccount(UserModifyRequest userModifyRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserModifyRequest> requestHttpEntity = new HttpEntity<>(userModifyRequest, headers);
        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.PUT, requestHttpEntity,
                        new ParameterizedTypeReference<>() {
                        });

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }

    public DeleteResponse deleteAccount(String userId) {

        ResponseEntity<DeleteResponse> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/" + userId, HttpMethod.DELETE,
                        null,
                        new ParameterizedTypeReference<>() {
                        });

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }

    public UserAuthDto matchesAccount(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequest> userAuthDtoHttpEntity = new HttpEntity<>(loginRequest, headers);
        ResponseEntity<UserAuthDto> responseEntity =
                restTemplate.exchange(accountAdaptorProperties.getAddress() + "/user/", HttpMethod.POST, userAuthDtoHttpEntity,
                        new ParameterizedTypeReference<>() {
                        });

        return responseEntity.getBody();

    }

}
