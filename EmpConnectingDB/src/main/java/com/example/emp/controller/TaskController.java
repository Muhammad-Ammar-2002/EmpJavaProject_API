package com.example.emp.controller;

import com.example.emp.Entity.TaskEntity;
import com.example.emp.model.TaskDTO;
import com.example.emp.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final ITaskService its;
    @Autowired
    public TaskController(ITaskService its){
        this.its=its;
    }

    @RequestMapping("/TaskDataI/{id}")

    public TaskDTO getTaskById(@PathVariable Long id)
    {
        return its.getTaskById(id);
    }



    @GetMapping
    public List<TaskDTO> getTaskList()
    {
        return its.getAllTasks();
    }

    @PostMapping
    public String saveTask(@RequestBody TaskDTO taskDto)
    {
        return its.saveTask(taskDto);
    }
    @PutMapping
    public  String updateTask(@RequestBody TaskDTO taskDto)
    {
        return its.updateTask(taskDto);
    }
    @PatchMapping
    public String patchUpdateTask(@RequestBody TaskDTO taskDto)
    {
        return its.patchUpdateTask(taskDto);
    }

    @DeleteMapping
    public String deleteTaskById(@RequestParam Long id)
    {
        return  its.deleteTask(id);
    }
}
