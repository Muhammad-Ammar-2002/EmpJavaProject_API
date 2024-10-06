package com.example.emp.service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Entity.ProjectEntity;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.repo.IEmpRepo;
import com.example.emp.repo.IProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpService implements IEmpService {

    private final IEmpRepo iempRepo;
    private final IProjectRepo iPrjectRepo;

    @Autowired
    public EmpService(IEmpRepo iempRepo,IProjectRepo iProjectRepo) {
        this.iempRepo = iempRepo;
        this.iPrjectRepo=iProjectRepo;
    }
    private EmployeeDTO casteEntityToDto(EmployeeEntity emp){
        EmployeeDTO empDto=new EmployeeDTO();
        empDto.setId(emp.getId());
        empDto.setFname(emp.getFname());
        empDto.setLname(emp.getLname());
        empDto.setSalary(emp.getSalary());
        empDto.setPhone(emp.getPhone());
        empDto.setSocialid(emp.getSocialid());
        empDto.setDepartment(emp.getDepartment());

        return empDto;
    }

    private EmployeeEntity casteDtoToEntity(EmployeeDTO empDto){
        EmployeeEntity emp=new EmployeeEntity();
        emp.setId(empDto.getId());
        emp.setFname(empDto.getFname());
        emp.setLname(empDto.getLname());
        emp.setSalary(empDto.getSalary());
        emp.setPhone(empDto.getPhone());
        emp.setSocialid(empDto.getSocialid());
        emp.setDepartment(empDto.getDepartment());

        return emp;
    }



    @Override
    public EmployeeDTO getEmpById(Long id){

        return casteEntityToDto(iempRepo.findById(id).get());
    }

    @Override
    public EmployeeDTO findByFname(String fname) {
        return casteEntityToDto(iempRepo.findByFname(fname));
    }


    @Override
    public List<EmployeeDTO> getBySalary(Double salary){
        return iempRepo.findBysalary(salary).stream().map(this::casteEntityToDto).collect(Collectors.toList());
    }



    @Override
    public List<EmployeeDTO> getAllEmp() {
       List<EmployeeEntity> emps=iempRepo.findAll();
        return emps.stream().map(this::casteEntityToDto).collect(Collectors.toList());



    }

    @Override
    public EmployeeDTO saveEmp(EmployeeDTO emp) {
        return casteEntityToDto(iempRepo.save(casteDtoToEntity(emp)));
    }

    @Override
    public EmployeeDTO updateEmp(EmployeeDTO emp) {
        return casteEntityToDto(iempRepo.save(casteDtoToEntity(emp)));

    }
    @Override
    public EmployeeDTO patchUpdateEmp(EmployeeDTO empDto,Long empId) {
     EmployeeEntity oldEmployeeEntity=iempRepo.findById(empId).get();
        if(empDto!=null)
        {
            if(empDto.getFname()!=null)
            {
                oldEmployeeEntity.setFname(empDto.getFname());
            }
            if(empDto.getLname()!=null)
            {
                oldEmployeeEntity.setLname(empDto.getLname());
            }
            if(empDto.getSalary()!=null)
            {
                oldEmployeeEntity.setSalary(empDto.getSalary());
            }
            if(empDto.getPhone()!=null)
            {
                oldEmployeeEntity.setPhone(empDto.getPhone());
            }
            if(empDto.getSocialid()!=null)
           {
              oldEmployeeEntity.setSocialid(empDto.getSocialid());
           }
            if(empDto.getDepartment()!=null) {
                oldEmployeeEntity.setDepartment(empDto.getDepartment());
            }

        }

            return  casteEntityToDto(iempRepo.save(oldEmployeeEntity));

    }

    @Override
    public String deleteEmpById(Long id) {
        iempRepo.deleteById(id);
        return "Emp deleted";
    }

    @Override
    public EmployeeDTO assignProjectToEmp(EmployeeDTO employeeDTO, Long projectId) {
//        ProjectEntity projectEntity=iPrjectRepo.findById(projectId).get();
        EmployeeEntity employeeEntity=casteDtoToEntity(employeeDTO);
        employeeEntity.setProjectEntity(iPrjectRepo.findById(projectId).get());
        return casteEntityToDto(iempRepo.save(employeeEntity));




    }


}
