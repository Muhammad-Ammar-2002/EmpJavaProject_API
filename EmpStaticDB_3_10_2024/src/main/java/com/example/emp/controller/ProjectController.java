package com.example.emp.controller;

import com.example.emp.repo.Project;
import com.example.emp.service.IProjectService;
import com.example.emp.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private  final IProjectService ips;
    public ProjectController(IProjectService ips) {
        this.ips = ips;
    }

    @GetMapping("/ProjectDataI/{id}")
    public Project getProjectById(@PathVariable Long id)
    {
        return ips.getProjectById(id);
    }



    @GetMapping
    public List<Project> getProjectList()
    {
        return ips.getAllProjects();
    }

    @PostMapping
    public String saveProject(@RequestBody Project project)
    {
        return ips.saveProject(project);
    }
    @PutMapping
    public  String updateProject(@RequestBody Project project)
    {
        return ips.updateProject(project);
    }
    @PatchMapping
    public String patchUpdateProject(@RequestBody Project project)
    {
        return ips.patchUpdateProject(project);
    }

    @DeleteMapping
    public String deleteProjectById(@RequestParam Long id)
    {
        return  ips.deleteProject(id);
    }


}
