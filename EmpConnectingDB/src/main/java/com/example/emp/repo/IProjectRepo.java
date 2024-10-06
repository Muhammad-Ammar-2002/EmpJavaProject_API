package com.example.emp.repo;

import com.example.emp.Entity.ProjectEntity;

import java.util.List;

public interface IProjectRepo {
    public ProjectEntity getProjectById(Long id);

    public List<ProjectEntity> getAllProjects();
    public ProjectEntity saveProject(ProjectEntity project);
    public ProjectEntity updateProject(ProjectEntity project);
    public  ProjectEntity patchUpdateProject(ProjectEntity project);
    public String deleteProject(Long id);


}
