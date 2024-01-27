package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.gateway.dto.task.TaskDto;
import com.nhnacademy.gateway.dto.tasktag.TaskTagNameResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class TaskTagAdaptor {
    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties taskAdaptorProperties;

    public List<TaskTagNameResponse> getAllTaskPreview(Long taskId) {

        ResponseEntity<List<TaskTagNameResponse>> responseEntity = restTemplate.exchange(
                taskAdaptorProperties.getAddress() + "/tasktags/" + taskId, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }
}
