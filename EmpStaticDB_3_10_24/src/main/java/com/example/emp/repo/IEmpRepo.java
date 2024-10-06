package com.example.emp.repo;

import java.util.List;

public interface IEmpRepo {
    public Employee getEmpById(long id);
    public Employee getEmpByName(String name);
    public Employee getEmpBySalary(String salary);



    public List<Employee> getAllEmp();
    public String saveEmp(Employee emp);
    public String updateEmp(Employee emp);
    public String patchUpdateEmp(Employee emp);
    public String deleteEmpById(Long id);
}
