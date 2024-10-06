package com.example.emp.service;

import com.example.emp.repo.Project;
import com.example.emp.repo.Task;

import java.util.List;

public interface IProjectService {
    public Project getProjectById(long id);

    public List<Project> getAllProjects();
    public String saveProject(Project project);
    public String updateProject(Project project);
    public String patchUpdateProject(Project project);
    public String deleteProject(Long id);
}
