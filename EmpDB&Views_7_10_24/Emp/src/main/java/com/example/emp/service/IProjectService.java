package com.example.emp.service;

import com.example.emp.Entity.ProjectEntity;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.model.ProjectDTO;

import java.util.List;

public interface IProjectService {
    public ProjectDTO getProjectById(Long id);
    public ProjectDTO findByName(String name);
    public List<ProjectDTO> getBySalary(Double salary);


    public List<ProjectDTO> getAllProjects();
    public ProjectDTO saveProject(ProjectDTO projectDto);
    public ProjectDTO updateProject(ProjectDTO projectDto);
    public ProjectDTO patchUpdateProject(ProjectDTO projectDto);
    public String deleteProject(Long id);
}
