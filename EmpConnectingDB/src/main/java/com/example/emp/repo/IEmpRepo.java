package com.example.emp.repo;

import com.example.emp.Entity.EmployeeEntity;

import java.util.List;

public interface IEmpRepo {
    public EmployeeEntity getEmpById(long id);
    public EmployeeEntity getEmpByName(String name);
    public EmployeeEntity getEmpBySalary(String salary);



    public List<EmployeeEntity> getAllEmp();
    public EmployeeEntity saveEmp(EmployeeEntity emp);
    public EmployeeEntity updateEmp(EmployeeEntity emp);
    public EmployeeEntity patchUpdateEmp(EmployeeEntity emp);
    public String deleteEmpById(Long id);
}
