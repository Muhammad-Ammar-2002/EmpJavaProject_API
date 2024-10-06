package com.example.emp.service;

import com.example.emp.Entity.TaskEntity;
import com.example.emp.model.TaskDTO;

import java.util.List;

public interface ITaskService {
    public TaskDTO getTaskById(Long id);

    public List<TaskDTO> getAllTasks();
    public String saveTask(TaskDTO taskDto);
    public  String updateTask(TaskDTO taskDto);
    public  String patchUpdateTask(TaskDTO taskDto);

    public  String deleteTask(Long id);
}
