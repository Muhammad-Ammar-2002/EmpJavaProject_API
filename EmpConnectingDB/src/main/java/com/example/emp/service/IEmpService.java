package com.example.emp.service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.model.EmployeeDTO;

import java.util.List;

public interface IEmpService {
    public EmployeeDTO getEmpById(Long id);
    public EmployeeDTO getEmpByName(String name);
    public EmployeeDTO getEmpBySalary(String salary);

    public List<EmployeeDTO> getAllEmp();
    public String saveEmp(EmployeeDTO empDTO);
    public String updateEmp(EmployeeDTO empDTO);
    public String patchUpdateEmp(EmployeeDTO empDTO);
    public String deleteEmpById(Long id);
}
