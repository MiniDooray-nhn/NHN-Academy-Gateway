package com.nhnacademy.gateway.dto.tasktag;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskTagResponse {

    private Long id;

    private Long taskId;

    private Long projectTagId;
}
