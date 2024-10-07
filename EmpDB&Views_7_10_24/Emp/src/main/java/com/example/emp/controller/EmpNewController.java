package com.example.emp.controller;

import org.springframework.ui.Model;

import com.example.emp.model.EmpCustomResponse;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.service.EmpService;
import com.example.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp/view")
public class EmpNewController {


    private final IEmpService iempService;


    @Autowired
    public EmpNewController(IEmpService iempService, EmpService empService) {
        this.iempService = iempService;

    }



    @GetMapping("/EmpDataI/{id}")
    public String getEmpById(@PathVariable Long id, Model model) {




        // Add the response to the model
        model.addAttribute("response",  iempService.getEmpById(id));

        // Return the view name
        return "emp";
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
    public String getEmpList(Model model) {

        List<EmployeeDTO> employeeDTOS=iempService.getAllEmp();
         model.addAttribute("allemplist", employeeDTOS);
        return "Allemp" ;
    }
    @GetMapping("/saveEmpView")
    public  String SaveEmp(Model model)
    {
        model.addAttribute("empDto",  new EmployeeDTO());

        return "AddEmp" ;
    }
@PostMapping
public  String SaveEmp(@ModelAttribute EmployeeDTO employeeDTO)
{
    iempService.saveEmp( employeeDTO);
    return "redirect:/emp/view" ;
}



@PutMapping
public String updateEmp( EmployeeDTO empDto)
{
   iempService.updateEmp(empDto);
    return "redirect:/emp/view" ;
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
