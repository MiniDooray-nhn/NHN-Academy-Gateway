package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.adapter.TaskAdaptor;
import com.nhnacademy.gateway.dto.task.TaskDto;
import com.nhnacademy.gateway.dto.task.TaskRegisterAndModifyRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskAdaptor taskAdaptor;

    @GetMapping("/tasks/modifyform/{id}")
    public String taskModifyForm(@PathVariable("id") Long taskId, Model model) {
        model.addAttribute("task", taskAdaptor.getTask(taskId));
        return "/project/taskModifyForm";
    }

    @GetMapping("/tasks")
    public String getAllTaskPreview(@RequestParam(name = "projectId") Long projectId, Model model) {
        List<TaskDto> taskList = taskAdaptor.getAllTaskPreview(projectId);
        model.addAttribute("taskList", taskList);
        return "/project/taskAllviewForm";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable("id") Long taskId, Model model) {
        TaskDto taskDto = taskAdaptor.getTask(taskId);
        model.addAttribute("task", taskDto);
        return "";
    }

    @PostMapping("/tasks")
    public String registerTask(@RequestBody TaskRegisterAndModifyRequest request) {
        taskAdaptor.createTask(request);
        return "project/taskAllviewForm";
    }

    @PutMapping("/tasks")
    public String modifyTask(@RequestBody TaskRegisterAndModifyRequest request) {
        taskAdaptor.modifyTask(request);
        return "project/taskAllviewForm";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable("id") Long taskId) {

        return "redirect:/project/taskAllviewForm";
    }
}
