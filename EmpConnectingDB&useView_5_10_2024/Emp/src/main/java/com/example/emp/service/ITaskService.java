package com.example.emp.service;

import com.example.emp.Entity.TaskEntity;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.model.TaskDTO;

import java.util.List;

public interface ITaskService {
    public TaskDTO getTaskById(Long id);
    public TaskDTO findByName(String name);
    public List<TaskDTO> getBySalary(Double salary);

    public List<TaskDTO> getAllTasks();
    public TaskDTO saveTask(TaskDTO taskDto);
    public  TaskDTO updateTask(TaskDTO taskDto);
    public  TaskDTO patchUpdateTask(TaskDTO taskDto);

    public  String deleteTask(Long id);
}
