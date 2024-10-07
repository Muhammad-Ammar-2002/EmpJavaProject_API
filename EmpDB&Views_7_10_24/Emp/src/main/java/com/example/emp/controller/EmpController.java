package com.example.emp.controller;

import com.example.emp.Entity.EmployeeEntity;

import com.example.emp.model.EmpCustomResponse;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.service.EmpService;
import com.example.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> getEmpById(@PathVariable Long id) {
        EmpCustomResponse<EmployeeDTO> response = new EmpCustomResponse("01","success",iempService.getEmpById(id));

        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }

    @GetMapping("/byName")
    public ResponseEntity<?> findByFname(@RequestParam String fname) {

        return new ResponseEntity<>(new EmpCustomResponse("01","success",iempService.findByFname(fname)),HttpStatus.OK);
    }

    @GetMapping("/bySalary")
    public ResponseEntity<?> getBySalary(@RequestParam Double salary) {

        return new ResponseEntity<>(new EmpCustomResponse("01","success",iempService.getBySalary(salary)),HttpStatus.OK);
    }




//    @RequestMapping("/")
    @GetMapping("/home")
    public String home() {
        return "home";
    }





    @GetMapping
    public ResponseEntity<?> getEmpList() {


        return new ResponseEntity<>(new EmpCustomResponse("01","success",iempService.getAllEmp()),HttpStatus.OK) ;
    }

@PostMapping
public  ResponseEntity<?> SaveEmp(@RequestBody EmployeeDTO empDto)
{
    return new ResponseEntity<>(new EmpCustomResponse("01","success",iempService.saveEmp(empDto)),HttpStatus.OK) ;
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
