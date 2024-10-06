package com.example.emp.controller;

import com.example.emp.Entity.EmployeeEntity;

import com.example.emp.model.EmpCustomResponse;
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

    public EmpCustomResponse<EmployeeDTO> getEmpById(@PathVariable Long id) {

        return new EmpCustomResponse("01","success",iempService.getEmpById(id));
    }

    @GetMapping("/byName")
    public EmpCustomResponse<EmployeeDTO> findByFname(@RequestParam String fname) {

        return new EmpCustomResponse("01","success",iempService.findByFname(fname));
    }

    @GetMapping("/bySalary")
    public EmpCustomResponse<List<EmployeeDTO>> getBySalary(@RequestParam Double salary) {

        return new EmpCustomResponse("01","success",iempService.getBySalary(salary));
    }




//    @RequestMapping("/")
    @GetMapping("/home")
    public String home() {
        return "home";
    }





    @GetMapping
    public EmpCustomResponse<List<EmployeeDTO>> getEmpList() {


        return new EmpCustomResponse("01","success",iempService.getAllEmp());
    }

@PostMapping
public  EmpCustomResponse<EmployeeDTO> SaveEmp(@RequestBody EmployeeDTO empDto)
{
    return  new EmpCustomResponse("01","success",iempService.saveEmp(empDto));
}
@PutMapping
public EmpCustomResponse<EmployeeDTO> updateEmp(@RequestBody EmployeeDTO empDto)
{
    return new EmpCustomResponse("01","success",iempService.updateEmp(empDto));
}
@PatchMapping
public EmpCustomResponse<EmployeeDTO> patchUpdateEmp(@RequestBody EmployeeDTO empDto,@RequestParam Long empId)
{
    return new EmpCustomResponse("01","success",iempService.patchUpdateEmp(empDto,empId));
}
@DeleteMapping
public  String deleteEmpById(@RequestParam Long id)
{
    return iempService.deleteEmpById(id);
}
@PutMapping("/assigProjectToEmp")
public EmpCustomResponse<EmployeeDTO> assignProjectToEmp(@RequestBody EmployeeDTO empDto,@RequestParam Long projectId)
{
    return new EmpCustomResponse("01","success",iempService.assignProjectToEmp(empDto,projectId));
}











}
