package com.example.emp.repo;

import java.util.List;

public interface ITaskRepo {
    public Task getTaskById(Long id);

    public List<Task> getAllTasks();
    public String saveTask(Task task);
    public  String updateTask(Task task);
    public  String patchUpdateTask(Task task);
    public  String deleteTask(Long id);
}
