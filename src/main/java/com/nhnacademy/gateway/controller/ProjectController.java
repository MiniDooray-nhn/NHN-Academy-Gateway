package com.nhnacademy.gateway.controller;


import com.nhnacademy.gateway.adapter.ProjectAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectAdaptor projectAdaptor;

    @PostMapping("/projects/")
    public String registerProject(){
//        projectAdaptor

                return  "project/home";
    }

    ///post/projects

}
