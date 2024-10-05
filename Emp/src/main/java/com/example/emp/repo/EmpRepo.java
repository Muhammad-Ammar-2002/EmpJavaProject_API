package com.example.emp.repo;

import com.example.emp.Entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpRepo implements IEmpRepo {



    @Override
    public EmployeeEntity getEmpById(long id) {

        return new EmployeeEntity(1,"Muhammad","11111111","23/4/2002");
    }
     @Override
    public EmployeeEntity getEmpByName(String name) {

        return new EmployeeEntity(2,"Muhammad","222222222","23/4/2002");
    }
    @Override
    public EmployeeEntity getEmpBySalary(String salary) {

        return new EmployeeEntity(9,"Muhammad","999999999","23/4/2002");
    }



    @Override
    public List<EmployeeEntity> getAllEmp() {
        return List.of(new EmployeeEntity(1,"Muhammad1","11111","23/4/2002")
                     ,new EmployeeEntity(2,"Muhammad2","22222","23/4/2002")
                     ,new EmployeeEntity(9,"Muhammad9","99999","23/4/2002")
                ,new EmployeeEntity(3,"Muhammad3","33333","23/4/2002"));
    }

    @Override
    public EmployeeEntity saveEmp(EmployeeEntity emp) {
        return emp;
    }

    @Override
    public EmployeeEntity updateEmp(EmployeeEntity emp) {
        if(emp !=null)
        {
            if(emp.getId()==0){return emp;}
            if(emp.getName()==null){return emp;}
            if(emp.getSalary()==null){return emp;}



            return  emp;
        }
      return emp;
    }


    @Override
    public EmployeeEntity patchUpdateEmp(EmployeeEntity emp) {
        return emp ;    }

    @Override
    public String deleteEmpById(Long id) {
        return "Done 1 row deleted;";
    }
}
