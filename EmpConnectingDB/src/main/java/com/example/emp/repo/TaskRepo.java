package com.example.emp.repo;


import com.example.emp.Entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepo implements ITaskRepo {



    @Override
    public TaskEntity getTaskById(Long id) {

        return new TaskEntity(1,"CreateTask","2000","2020","2024");
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return List.of(new TaskEntity(1,"showTask","2000","2020","2024"),
                new TaskEntity(1,"showTask","2000","2020","2024"),
        new TaskEntity(1,"showTask","2000","2020","2024"));
    }

    @Override
    public TaskEntity saveTask(TaskEntity taskEntity) {
        return  taskEntity;
    }

    @Override
    public TaskEntity updateTask(TaskEntity taskEntity) {

       return  taskEntity;
          }


    @Override
    public TaskEntity patchUpdateTask(TaskEntity taskEntity) {
        return  taskEntity ;    }
    @Override
    public String deleteTask(Long id) {
        return "Done 1 row deleted;";
    }
}
