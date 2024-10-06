package com.example.emp.service;

import com.example.emp.repo.Employee;

import java.util.List;

public interface IEmpService {
    public Employee getEmpById(Long id);
    public Employee getEmpByName(String name);
    public Employee getEmpBySalary(String salary);

    public List<Employee> getAllEmp();
    public String saveEmp(Employee emp);
    public String updateEmp(Employee emp);
    public String patchUpdateEmp(Employee emp);
    public String deleteEmpById(Long id);
}
