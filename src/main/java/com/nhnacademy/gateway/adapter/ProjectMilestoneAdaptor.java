package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.gateway.dto.projectmilesstone.ProjectMileStoneResponse;
import com.nhnacademy.gateway.dto.task.TaskDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProjectMilestoneAdaptor {
    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties taskAdaptorProperties;

    public List<ProjectMileStoneResponse> getAllProjectMilestone(Long id) {
        ResponseEntity<List<ProjectMileStoneResponse>> responseEntity = restTemplate.exchange(
                taskAdaptorProperties.getAddress() + "/" + id + "/milestone", HttpMethod.GET, null,

                new ParameterizedTypeReference<>() {
                });
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }
}
