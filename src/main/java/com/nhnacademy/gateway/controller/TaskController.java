package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.adapter.TaskAdaptor;
import com.nhnacademy.gateway.domain.task.TaskDto;
import com.nhnacademy.gateway.domain.task.TaskPreviewDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskAdaptor taskAdaptor;


    @GetMapping("/tasks")
    public String getAllTaskPreview(@RequestParam(name = "projectId") Long projectId, Model model) {
        List<TaskDto> taskList = taskAdaptor.getAllTaskPreview(projectId);
        model.addAttribute("taskList", taskList);
        return "/project/taskAllviewForm";
    }

}
