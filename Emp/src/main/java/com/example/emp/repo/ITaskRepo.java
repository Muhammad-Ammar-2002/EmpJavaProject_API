package com.example.emp.repo;

import com.example.emp.Entity.TaskEntity;

import java.util.List;

public interface ITaskRepo {
    public TaskEntity getTaskById(Long id);

    public List<TaskEntity> getAllTasks();
    public TaskEntity saveTask(TaskEntity taskEntity);
    public  TaskEntity updateTask(TaskEntity taskEntity);
    public  TaskEntity patchUpdateTask(TaskEntity taskEntity);
    public  String deleteTask(Long id);
}
