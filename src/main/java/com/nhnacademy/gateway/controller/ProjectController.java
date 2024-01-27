package com.nhnacademy.gateway.controller;


import com.nhnacademy.gateway.adapter.ProjectAdaptor;
import com.nhnacademy.gateway.dto.project.ProjectDto;
import com.nhnacademy.gateway.dto.project.ProjectRegisterAndModifyRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectAdaptor projectAdaptor;

    @GetMapping("/projects/{userid}")
    public String getProjectsUserRegistered(@PathVariable(name = "userid") String userId, Model model) {
        List<ProjectDto> projectDtoList = projectAdaptor.getProjectsUserRegistered(userId);
        model.addAttribute("projectList", projectDtoList);
        return "project/home";
    }

    @PostMapping("/projects")
    public String registerProject(@RequestBody ProjectRegisterAndModifyRequest registerRequest) {
        projectAdaptor.registerProjects(registerRequest);
        return "project/home";
    }


}
