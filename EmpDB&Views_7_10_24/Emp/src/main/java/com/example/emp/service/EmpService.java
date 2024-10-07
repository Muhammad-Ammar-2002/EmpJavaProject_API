package com.example.emp.service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Entity.ProjectEntity;
import com.example.emp.Exceptions.CustomeException;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.repo.IEmpRepo;
import com.example.emp.repo.IProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.CertificateException;
import java.util.ArrayList;
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
        empDto.setSocialId(emp.getSocialid());
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
        emp.setSocialid(empDto.getSocialId());
        emp.setDepartment(empDto.getDepartment());

        return emp;
    }



    @Override
    public EmployeeDTO getEmpById(Long id){

        return casteEntityToDto(iempRepo.findById(id).orElseThrow(()-> new CustomeException("failed to find id: "+id)));
    }

    @Override
    public EmployeeDTO findByFname(String fname) {

        if(iempRepo.findByFname(fname)==null)
        {
              throw new CustomeException("fname not found");
        }
        return casteEntityToDto(iempRepo.findByFname(fname));
    }


    @Override
    public List<EmployeeDTO> getBySalary(Double salary){
        if( salary==null)
        {
            throw new CustomeException("Provide salary please");
        }
        List<EmployeeDTO> employees=iempRepo.findBysalary(salary).stream().map(this::casteEntityToDto).collect(Collectors.toList());
        if( employees.isEmpty())
        {
            throw new CustomeException("salary not found");
        }
        return employees;
    }



    @Override
    public List<EmployeeDTO> getAllEmp() {
//       List<EmployeeEntity> emps=iempRepo.findAll();
//       if(emps.isEmpty())
//       {
//           throw new CustomeException("emp not found");
//       }
        return iempRepo.findAll().stream().map(this::casteEntityToDto).collect(Collectors.toList());



    }

    @Override
    public EmployeeDTO saveEmp(EmployeeDTO emp) {

//        EmployeeEntity savedEntity=iempRepo.save(casteDtoToEntity(emp));
//        if( !savedEntity.getId().equals(emp.getId()))
//        {
//            throw new CustomeException("emp not saved");
//        }
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
            if(empDto.getSocialId()!=null)
           {
              oldEmployeeEntity.setSocialid(empDto.getSocialId());
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
