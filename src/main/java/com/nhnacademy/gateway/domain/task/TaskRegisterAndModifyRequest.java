package com.nhnacademy.gateway.domain.task;

import lombok.Data;

@Data
public class TaskRegisterAndModifyRequest {

    private Long id;

    private String userId;

    private String title;

    private String contents;

    private Long projectId;

}
