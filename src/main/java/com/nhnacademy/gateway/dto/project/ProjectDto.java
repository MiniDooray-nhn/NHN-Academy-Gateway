package com.nhnacademy.gateway.dto.project;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjectDto {
    Long id;

    String projectStatusName;

    String title;

    LocalDate createdAt;
}
