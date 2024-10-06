package com.example.emp.service;

import com.example.emp.repo.Task;

import java.util.List;

public interface ITaskService {
    public Task getTaskById(Long id);

    public List<Task> getAllTasks();
    public String saveTask(Task task);
    public  String updateTask(Task task);
    public  String patchUpdateTask(Task task);

    public  String deleteTask(Long id);
}
