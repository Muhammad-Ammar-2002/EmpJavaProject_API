package com.example.emp.service;

import com.example.emp.repo.EmpRepo;
import com.example.emp.repo.Employee;
import com.example.emp.repo.IEmpRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService implements IEmpService {

    private final IEmpRepo iempRepo;
    public EmpService(IEmpRepo iempRepo) {
        this.iempRepo = iempRepo;
    }

    @Override
    public Employee getEmpById(Long id){
        return iempRepo.getEmpById(id);
    }
    @Override
    public Employee getEmpByName(String name){
        return iempRepo.getEmpByName(name);
    }
    @Override
    public Employee getEmpBySalary(String salary){
        return iempRepo.getEmpBySalary(salary);
    }



    @Override
    public List<Employee> getAllEmp() {
        return iempRepo.getAllEmp();
    }

    @Override
    public String saveEmp(Employee emp) {
        return iempRepo.saveEmp(emp);
    }

    @Override
    public String updateEmp(Employee emp) {
        return iempRepo.updateEmp(emp);

    }
    @Override
    public String patchUpdateEmp(Employee emp) {

            return  iempRepo.patchUpdateEmp(emp);

    }

    @Override
    public String deleteEmpById(Long id) {

        return iempRepo.deleteEmpById(id);
    }
}
