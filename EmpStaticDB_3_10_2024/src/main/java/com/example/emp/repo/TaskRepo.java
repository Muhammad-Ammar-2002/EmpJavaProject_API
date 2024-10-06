package com.example.emp.repo;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepo implements ITaskRepo {



    @Override
    public Task getTaskById(Long id) {

        return new Task(1,"CreateTask","2000","2020","2024");
    }

    @Override
    public List<Task> getAllTasks() {
        return List.of(new Task(1,"showTask","2000","2020","2024"),
                new Task(1,"showTask","2000","2020","2024"),
        new Task(1,"showTask","2000","2020","2024"));
    }

    @Override
    public String saveTask(Task task) {
        return "Done 1 row saved;"+task.toString() ;
    }

    @Override
    public String updateTask(Task task) {
        if(task !=null)
        {
            if(task.getId()==0){return "Please update your id. "+task.toString();}
            if(task.getName()==null){return "Please update your name. "+task;}
            if(task.getSalary()==null){return "Please update your salary. "+task.toString();}



            return  "Done 1 row updated;"+task.toString();
        }
        return  "error";    }


    @Override
    public String patchUpdateTask(Task task) {
        return "Done 1 row saved;"+task.toString() ;    }
    @Override
    public String deleteTask(Long id) {
        return "Done 1 row deleted;";
    }
}
