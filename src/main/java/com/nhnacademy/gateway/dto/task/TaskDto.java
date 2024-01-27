package com.nhnacademy.gateway.dto.task;

import com.nhnacademy.gateway.dto.project.Project;
import com.nhnacademy.gateway.dto.project.ProjectDto;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TaskDto {
    Long id;
    String userId;
    String title;
    String contents;
    LocalDateTime CreatedAt;
    Project project;
}

