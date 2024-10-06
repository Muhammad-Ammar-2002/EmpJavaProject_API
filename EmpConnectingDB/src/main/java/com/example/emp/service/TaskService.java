package com.example.emp.service;

import com.example.emp.Entity.TaskEntity;
import com.example.emp.model.TaskDTO;
import com.example.emp.repo.ITaskRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepo its;

    @Autowired
    public TaskService(ITaskRepo its){
        this.its=its;
    }

    private TaskDTO casteTaskToDto(TaskEntity taskEntity){
        TaskDTO taskDTO=new TaskDTO();
        taskDTO.setId(taskEntity.getId());
        taskDTO.setName(taskEntity.getName());
        taskDTO.setSalary(taskEntity.getSalary());

        return taskDTO;
    }
    private TaskEntity casteDtoToTask(TaskDTO taskDTO){
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setId(taskDTO.getId());
        taskEntity.setName(taskDTO.getName());
        taskEntity.setSalary(taskDTO.getSalary());

        return taskEntity;
    }


    @Override
    public TaskDTO getTaskById(Long id) {
        return casteTaskToDto( its.getTaskById(id));
    }
    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> taskEntities=its.getAllTasks();
        return taskEntities.stream().map(tk->casteTaskToDto(tk)).collect(Collectors.toList()) ;
    }

    @Override
    public String saveTask(TaskDTO taskDto) {
        return "Done 1 row saved;"+casteTaskToDto( its.saveTask(casteDtoToTask(taskDto)));
    }

    @Override
    public String updateTask(TaskDTO taskDto) {
//        if(taskEntity !=null)
//        {
//            if(taskEntity.getId()==0){return "Please update your id: "+ taskEntity;}
//            if(taskEntity.getName()==null){return "Please update your name: "+ taskEntity;}
//            if(taskEntity.getSalary()==null){return "Please update your salary: "+ taskEntity;}
//
//
//
//            return  "Done 1 row updated;"+ taskEntity;
//        }
//        return  "error";
        return "put update"+casteTaskToDto(its.patchUpdateTask(casteDtoToTask(taskDto)));
    }

    @Override
    public String patchUpdateTask(TaskDTO taskDto) {
        return "Done 1 row saved;"+casteTaskToDto(its.patchUpdateTask(casteDtoToTask(taskDto)));
    }

    @Override
    public String deleteTask(Long id) {
        return its.deleteTask(id);
    }
}
