package com.example.emp.service;

import com.example.emp.Entity.ProjectEntity;
import com.example.emp.model.ProjectDTO;

import java.util.List;

public interface IProjectService {
    public ProjectDTO getProjectById(Long id);

    public List<ProjectDTO> getAllProjects();
    public String saveProject(ProjectDTO projectDTO);
    public String updateProject(ProjectDTO projectDTO);
    public String patchUpdateProject(ProjectDTO projectDTO);
    public String deleteProject(Long id);
}
