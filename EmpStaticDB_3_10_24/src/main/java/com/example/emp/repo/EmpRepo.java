package com.example.emp.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpRepo implements IEmpRepo {



    @Override
    public Employee getEmpById(long id) {

        return new Employee(1,"Muhammad","11111111","23/4/2002");
    }
     @Override
    public Employee getEmpByName(String name) {

        return new Employee(2,"Muhammad","222222222","23/4/2002");
    }
    @Override
    public Employee getEmpBySalary(String salary) {

        return new Employee(9,"Muhammad","999999999","23/4/2002");
    }



    @Override
    public List<Employee> getAllEmp() {
        return List.of(new Employee(1,"Muhammad","11111111","23/4/2002")
                     ,new Employee(2,"Muhammad","222222222","23/4/2002")
                     ,new Employee(9,"Muhammad","999999999","23/4/2002"));
    }

    @Override
    public String saveEmp(Employee emp) {
        return "Done 1 row added;"+emp.toString();
    }

    @Override
    public String updateEmp(Employee emp) {
        if(emp !=null)
        {
            if(emp.getId()==0){return "Please update your id. "+emp.toString();}
            if(emp.getName()==null){return "Please update your name. "+emp;}
            if(emp.getSalary()==null){return "Please update your salary. "+emp.toString();}



            return  "Done 1 row updated;"+emp.toString();
        }
        return  "error";
    }


    @Override
    public String patchUpdateEmp(Employee emp) {
        return "Done 1 row saved;"+emp.toString() ;    }

    @Override
    public String deleteEmpById(Long id) {
        return "Done 1 row deleted;";
    }
}
