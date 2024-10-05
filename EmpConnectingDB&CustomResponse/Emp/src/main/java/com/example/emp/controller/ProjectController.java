package com.example.emp.controller;


import com.example.emp.model.EmployeeDTO;
import com.example.emp.model.ProjectDTO;
import com.example.emp.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private  final IProjectService ips;
    @Autowired
    public ProjectController(IProjectService ips) {
        this.ips = ips;
    }

    @GetMapping("/ProjectDataI/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id)
    {
        return ips.getProjectById(id);
    }

    @GetMapping("/byName")
    public ProjectDTO findByFname(@RequestParam String name) {

        return ips.findByName(name);
    }

    @GetMapping("/bySalary")
    public List<ProjectDTO> getBySalary(@RequestParam Double salary) {

        return ips.getBySalary(salary);
    }


    @GetMapping
    public List<ProjectDTO> getProjectList()
    {
        return ips.getAllProjects();
    }

    @PostMapping
    public ProjectDTO saveProject(@RequestBody ProjectDTO project)
    {
        return ips.saveProject(project);
    }
    @PutMapping
    public  ProjectDTO updateProject(@RequestBody ProjectDTO project)
    {
        return ips.updateProject(project);
    }
    @PatchMapping
    public ProjectDTO patchUpdateProject(@RequestBody ProjectDTO project)
    {
        return ips.patchUpdateProject(project);
    }

    @DeleteMapping
    public String deleteProjectById(@RequestParam Long id)
    {
        return  ips.deleteProject(id);
    }


}
