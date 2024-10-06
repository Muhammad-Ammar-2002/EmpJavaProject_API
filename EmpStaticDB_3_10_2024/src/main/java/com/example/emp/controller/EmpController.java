package com.example.emp.controller;

import com.example.emp.repo.Employee;

import com.example.emp.service.EmpService;
import com.example.emp.service.IEmpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {


    private final IEmpService iempService;


    public EmpController(IEmpService iempService, EmpService empService) {
        this.iempService = iempService;

    }



    @GetMapping("/EmpDataI/{id}")

    public Employee getEmpById(@PathVariable Long id) {

        return iempService.getEmpById(id);
    }

    @GetMapping("/EmpDataN/{name}")
    public Employee getEmpByName(@PathVariable String name) {

        return iempService.getEmpByName(name);
    }

    @GetMapping("/EmpDataS/{salary}")
    public Employee getEmpBySalary(@PathVariable String salary) {

        return iempService.getEmpBySalary(salary);
    }




//    @RequestMapping("/")
    @GetMapping("/home")
    public String home() {
        return "home";
    }





    @GetMapping
    public List<Employee> getEmpList() {
        return iempService.getAllEmp();
    }

@PostMapping
public  String SaveEmp(@RequestBody Employee emp)
{
    return  iempService.saveEmp(emp);
}
@PutMapping
public String updateEmp(@RequestBody Employee emp)
{
    return iempService.updateEmp(emp);
}
@PatchMapping
public String patchUpdateEmp(@RequestBody Employee emp)
{
    return iempService.patchUpdateEmp(emp);
}
@DeleteMapping
public  String deleteEmpById(@RequestParam Long id)
{
    return iempService.deleteEmpById(id);
}


}
