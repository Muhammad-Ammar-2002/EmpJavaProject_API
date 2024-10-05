package com.example.emp.repo;

import com.example.emp.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IEmpRepo extends JpaRepository<EmployeeEntity, Long> {


   @Query(value = "select * from employee_entity e where e.fname=:fname",nativeQuery = true)
    public EmployeeEntity findByFname(String fname);

//   public List<EmployeeEntity> findBysalary(double salary);

    @Query("from EmployeeEntity e where e.salary=:salary")
    public List<EmployeeEntity> findBysalary(Double salary);

}
