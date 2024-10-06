package com.example.emp.repo;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProjectRepo extends JpaRepository<ProjectEntity, Long> {


    @Query(value = "select * from project_entity p where p.name=:name",nativeQuery = true)
    public ProjectEntity findByFname(String name);

//   public List<EmployeeEntity> findBysalary(double salary);

    @Query("from ProjectEntity  p where p.salary=:salary")
    public List<ProjectEntity> findBysalary(Double salary);


}
