package com.example.emp.controller;

import com.example.emp.repo.Task;
import com.example.emp.repo.Task;
import com.example.emp.service.ITaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final ITaskService its;
    public TaskController(ITaskService its){
        this.its=its;
    }

    @RequestMapping("/TaskDataI/{id}")

    public Task getTaskById(@PathVariable Long id)
    {
        return its.getTaskById(id);
    }



    @GetMapping
    public List<Task> getTaskList()
    {
        return its.getAllTasks();
    }

    @PostMapping
    public String saveTask(@RequestBody Task task)
    {
        return its.saveTask(task);
    }
    @PutMapping
    public  String updateTask(@RequestBody Task task)
    {
        return its.updateTask(task);
    }
    @PatchMapping
    public String patchUpdateTask(@RequestBody Task task)
    {
        return its.patchUpdateTask(task);
    }

    @DeleteMapping
    public String deleteTaskById(@RequestParam Long id)
    {
        return  its.deleteTask(id);
    }
}
