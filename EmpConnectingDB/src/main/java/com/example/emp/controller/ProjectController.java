package com.example.emp.controller;

import com.example.emp.Entity.ProjectEntity;
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



    @GetMapping
    public List<ProjectDTO> getProjectList()
    {
        return ips.getAllProjects();
    }

    @PostMapping
    public String saveProject(@RequestBody ProjectDTO projectDTO)
    {
        return ips.saveProject(projectDTO);
    }
    @PutMapping
    public  String updateProject(@RequestBody ProjectDTO projectDTO)
    {
        return ips.updateProject(projectDTO);
    }
    @PatchMapping
    public String patchUpdateProject(@RequestBody ProjectDTO projectDTO)
    {
        return ips.patchUpdateProject(projectDTO);
    }

    @DeleteMapping
    public String deleteProjectById(@RequestParam Long id)
    {
        return  ips.deleteProject(id);
    }


}
