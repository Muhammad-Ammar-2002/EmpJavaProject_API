package com.example.emp.controller;

import com.example.emp.Entity.EmployeeEntity;

import com.example.emp.model.EmployeeDTO;
import com.example.emp.service.EmpService;
import com.example.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {


    private final IEmpService iempService;


    @Autowired
    public EmpController(IEmpService iempService, EmpService empService) {
        this.iempService = iempService;

    }



    @GetMapping("/EmpDataI/{id}")

    public EmployeeDTO getEmpById(@PathVariable Long id) {

        return iempService.getEmpById(id);
    }

    @GetMapping("/EmpDataN/{name}")
    public EmployeeDTO getEmpByName(@PathVariable String name) {

        return iempService.getEmpByName(name);
    }

    @GetMapping("/EmpDataS/{salary}")
    public EmployeeDTO getEmpBySalary(@PathVariable String salary) {

        return iempService.getEmpBySalary(salary);
    }




//    @RequestMapping("/")
    @GetMapping("/home")
    public String home() {
        return "home";
    }





    @GetMapping
    public List<EmployeeDTO> getEmpList() {
        return iempService.getAllEmp();
    }

@PostMapping
public  String SaveEmp(@RequestBody  EmployeeDTO empDTO)
{
    return  iempService.saveEmp(empDTO);
}
@PutMapping
public String updateEmp(@RequestBody EmployeeDTO empDTO)
{
    return iempService.updateEmp( empDTO);
}
@PatchMapping
public String patchUpdateEmp(@RequestBody EmployeeDTO empDTO)
{
    return iempService.patchUpdateEmp( empDTO);
}
@DeleteMapping
public  String deleteEmpById(@RequestParam Long id)
{
    return iempService.deleteEmpById(id);
}


}
