package com.nhnacademy.gateway.controller;


import com.nhnacademy.gateway.adapter.ProjectAdaptor;
import com.nhnacademy.gateway.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.gateway.dto.project.ProjectRegisterAndModifyResponse;
import com.nhnacademy.gateway.dto.project.ProjectResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectAdaptor projectAdaptor;

    @GetMapping("/{userid}")
    public String getProjectsUserRegistered(@PathVariable(name = "userid") String userId, Model model) {
        List<ProjectResponse> projectDtoList = projectAdaptor.getProjectsUserRegistered(userId);
        model.addAttribute("projectList", projectDtoList);
        return "project/home";
    }

    @PostMapping
    public String registerProject(@RequestBody ProjectRegisterAndModifyRequest registerRequest) {
        projectAdaptor.registerProjects(registerRequest);
        return "project/home";
    }

    @PutMapping("/{projectId}")
    public String modifyProject(@PathVariable(name = "projectId") Long id
            , @RequestBody ProjectRegisterAndModifyRequest modifyRequest, Model model) {

        ProjectRegisterAndModifyResponse projectRegisterAndModifyResponse =
                projectAdaptor.modifyProjectByRequestAndId(modifyRequest, id);

        model.addAttribute("projectRegisterAndModifyResponse", projectRegisterAndModifyResponse);

        return "project/home";
    }


}
