package com.example.emp.repo;


import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface ITaskRepo extends JpaRepository<TaskEntity, Long> {
    @Query(value = "select * from task_entity e where e.name=:name",nativeQuery = true)
    public TaskEntity findByName(String name);

//   public List<EmployeeEntity> findBysalary(double salary);

    @Query("from TaskEntity t where t.salary=:salary")
    public List<TaskEntity> findBysalary(Double salary);

}
