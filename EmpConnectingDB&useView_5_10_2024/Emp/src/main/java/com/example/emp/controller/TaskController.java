package com.example.emp.controller;

import com.example.emp.Entity.TaskEntity;
import com.example.emp.model.ProjectDTO;
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

    @GetMapping("/byName")
    public TaskDTO findByName(@RequestParam String name) {

        return its.findByName(name);
    }

    @GetMapping("/bySalary")
    public List<TaskDTO> getBySalary(@RequestParam Double salary) {

        return its.getBySalary(salary);
    }


    @GetMapping
    public List<TaskDTO> getTaskList()
    {
        return its.getAllTasks();
    }

    @PostMapping
    public TaskDTO saveTask(@RequestBody TaskDTO taskdTO)
    {
        return its.saveTask(taskdTO);
    }
    @PutMapping
    public  TaskDTO updateTask(@RequestBody TaskDTO taskdTO)
    {
        return its.updateTask(taskdTO);
    }
    @PatchMapping
    public TaskDTO patchUpdateTask(@RequestBody TaskDTO taskdTO)
    {
        return its.patchUpdateTask(taskdTO);
    }

    @DeleteMapping
    public String deleteTaskById(@RequestParam Long id)
    {
        return its.deleteTask(id);
    }
}
