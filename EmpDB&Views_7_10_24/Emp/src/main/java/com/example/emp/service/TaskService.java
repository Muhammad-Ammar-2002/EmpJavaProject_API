package com.example.emp.service;

import com.example.emp.Entity.TaskEntity;
import com.example.emp.model.EmployeeDTO;
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
    private TaskEntity casteDtoToEntity(TaskDTO taskDto){
        TaskEntity task=new TaskEntity();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setSalary(taskDto.getSalary());

        return task;
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return casteTaskToDto( its.findById(id).get());
    }

    @Override
    public TaskDTO findByName(String name) {
        return casteTaskToDto(its.findByName(name));
    }


    @Override
    public List<TaskDTO> getBySalary(Double salary) {
        return its.findBysalary(salary).stream().map(this::casteTaskToDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> taskEntities=its.findAll();
        return taskEntities.stream().map(this::casteTaskToDto).collect(Collectors.toList()) ;
    }

    @Override
    public TaskDTO saveTask(TaskDTO taskDto) {
        return casteTaskToDto( its.save(casteDtoToEntity(taskDto)));
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDto) {
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
        return casteTaskToDto(its.save(casteDtoToEntity(taskDto)));
    }

    @Override
    public TaskDTO patchUpdateTask(TaskDTO taskDto) {
        return casteTaskToDto(its.save(casteDtoToEntity(taskDto)));
    }

    @Override
    public String deleteTask(Long id) {
        its.deleteById(id);
        return "Emp deleted";
    }
}
