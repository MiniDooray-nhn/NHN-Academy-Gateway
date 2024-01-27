package com.nhnacademy.gateway.dto.project;

import lombok.Data;

@Data
public class ProjectRegisterAndModifyRequest {
    private String userId;

    private Integer projectStatusId;

    private String title;


}
