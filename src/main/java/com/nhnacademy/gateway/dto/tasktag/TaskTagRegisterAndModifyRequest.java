package com.nhnacademy.gateway.dto.tasktag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskTagRegisterAndModifyRequest {
    private Long id;

    private Long taskId;

    private Long projectTagId;
}
