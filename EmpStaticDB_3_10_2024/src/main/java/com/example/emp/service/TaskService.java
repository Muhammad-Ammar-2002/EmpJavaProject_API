package com.example.emp.service;

import com.example.emp.repo.Task;
import com.example.emp.repo.ITaskRepo;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepo its;

    public TaskService(ITaskRepo its){
        this.its=its;
    }

    @Override
    public Task getTaskById(Long id) {
        return its.getTaskById(id);
    }
    @Override
    public List<Task> getAllTasks() {
        return its.getAllTasks();
    }

    @Override
    public String saveTask(Task task) {
        return its.saveTask(task);
    }

    @Override
    public String updateTask(Task task) {
        if(task !=null)
        {
            if(task.getId()==0){return "Please update your id: "+task;}
            if(task.getName()==null){return "Please update your name: "+task;}
            if(task.getSalary()==null){return "Please update your salary: "+task;}



            return  "Done 1 row updated;"+task;
        }
        return  "error";
    }

    @Override
    public String patchUpdateTask(Task task) {
        return its.patchUpdateTask(task);
    }

    @Override
    public String deleteTask(Long id) {
        return its.deleteTask(id);
    }
}
