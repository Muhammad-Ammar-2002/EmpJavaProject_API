package com.example.emp.service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.repo.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpService implements IEmpService {

    private final IEmpRepo iempRepo;
    @Autowired
    public EmpService(IEmpRepo iempRepo) {
        this.iempRepo = iempRepo;
    }
    private EmployeeDTO casteEntityToDto(EmployeeEntity emp){
        EmployeeDTO empDto=new EmployeeDTO();
        empDto.setId(emp.getId());
        empDto.setName(emp.getName());
        empDto.setSalary(emp.getSalary());

        return empDto;
    }
    private EmployeeEntity casteDtoToEntity(EmployeeDTO dto){
        EmployeeEntity empEntity=new EmployeeEntity();
        empEntity.setId(dto.getId());
        empEntity.setName(dto.getName());
        empEntity.setSalary(dto.getSalary());

        return empEntity;
    }



    @Override
    public EmployeeDTO getEmpById(Long id){

        return casteEntityToDto(iempRepo.getEmpById(id));
    }
    @Override
    public EmployeeDTO getEmpByName(String name){
        return casteEntityToDto(iempRepo.getEmpByName(name));
    }
    @Override
    public EmployeeDTO getEmpBySalary(String salary){
        return casteEntityToDto(iempRepo.getEmpBySalary(salary));
    }



    @Override
    public List<EmployeeDTO> getAllEmp() {
        return iempRepo.getAllEmp().stream().map(emp->casteEntityToDto(emp)).collect(Collectors.toList());



    }

    @Override
    public String saveEmp(EmployeeDTO empDTO) {
        return "post"+casteEntityToDto(iempRepo.saveEmp(casteDtoToEntity(empDTO)));
    }

    @Override
    public String updateEmp(EmployeeDTO empDTO) {
        return "Put"+casteEntityToDto(iempRepo.updateEmp(casteDtoToEntity(empDTO)));

    }
    @Override
    public String patchUpdateEmp(EmployeeDTO empDTO) {

            return  "patch"+casteEntityToDto(iempRepo.patchUpdateEmp(casteDtoToEntity(empDTO)));

    }

    @Override
    public String deleteEmpById(Long id) {

        return "Done 1 row deleted";
    }




}
