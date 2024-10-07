package com.example.emp.service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.model.EmployeeDTO;

import java.util.List;

public interface IEmpService {
    public EmployeeDTO getEmpById(Long id);
    public EmployeeDTO findByFname(String fname);
    public List<EmployeeDTO> getBySalary(Double salary);

    public List<EmployeeDTO> getAllEmp();
    public EmployeeDTO saveEmp(EmployeeDTO employeeDTO);
    public EmployeeDTO updateEmp(EmployeeDTO employeeDTO);
    public EmployeeDTO patchUpdateEmp(EmployeeDTO employeeDTO,Long empId);
    public String deleteEmpById(Long id);

    public EmployeeDTO assignProjectToEmp(EmployeeDTO employeeDTO,Long projectId);
}
