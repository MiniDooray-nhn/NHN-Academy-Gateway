package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.gateway.dto.project.ProjectDto;
import com.nhnacademy.gateway.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.gateway.dto.task.Account;
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
public class ProjectAdaptor {

    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties taskAdaptorProperties;


    public List<ProjectDto> getProjectsUserRegistered(String userid) {
        ResponseEntity<List<ProjectDto>>
                responseEntity =
                restTemplate.exchange(taskAdaptorProperties.getAddress() + "/projects/user/" + userid, HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }


    public void registerProjects(ProjectRegisterAndModifyRequest registerRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProjectRegisterAndModifyRequest> request = new HttpEntity<>(registerRequest, headers);
        ResponseEntity<ProjectRegisterAndModifyRequest> responseEntity =
                restTemplate.exchange(taskAdaptorProperties.getAddress() + "/projects", HttpMethod.POST, request,
                        new ParameterizedTypeReference<>() {
                        });
        if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }
    }
}
