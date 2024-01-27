package com.nhnacademy.gateway.adapter;


import com.nhnacademy.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.gateway.dto.task.TaskDto;
import com.nhnacademy.gateway.dto.task.TaskRegisterAndModifyRequest;
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
public class TaskAdaptor {
    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties taskAdaptorProperties;


    public List<TaskDto> getAllTaskPreview(Long projectId) {

        ResponseEntity<List<TaskDto>> responseEntity = restTemplate.exchange(
                taskAdaptorProperties.getAddress() + "/tasks?projectId=" + projectId, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }


    public TaskDto getTask(Long id) {
        ResponseEntity<TaskDto>
                responseEntity =
                restTemplate.exchange(taskAdaptorProperties.getAddress() + "/tasks/" + id, HttpMethod.GET,
                        null, new ParameterizedTypeReference<>() {
                        }, id);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }


    public void createTask(TaskRegisterAndModifyRequest registerRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TaskRegisterAndModifyRequest> request = new HttpEntity<>(registerRequest, headers);
        ResponseEntity<TaskDto> responseEntity =
                restTemplate.exchange(taskAdaptorProperties.getAddress() + "/accounts", HttpMethod.POST, request,
                        new ParameterizedTypeReference<>() {
                        });
        if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }
    }

    public void modifyTask(TaskRegisterAndModifyRequest registerRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TaskRegisterAndModifyRequest> request = new HttpEntity<>(registerRequest, headers);
        ResponseEntity<TaskDto> responseEntity =
                restTemplate.exchange(taskAdaptorProperties.getAddress() + "/accounts", HttpMethod.PUT, request,
                        new ParameterizedTypeReference<>() {
                        });
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
    }

}
