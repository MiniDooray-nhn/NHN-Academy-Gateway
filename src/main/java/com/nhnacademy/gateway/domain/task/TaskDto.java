package com.nhnacademy.gateway.domain.task;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TaskDto {
    Long id;
    String userId;
    String title;
    String contents;
    LocalDateTime CreatedAt;
    Long projectId;
}

