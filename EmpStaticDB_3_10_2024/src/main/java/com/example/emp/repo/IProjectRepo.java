package com.example.emp.repo;

import java.util.List;

public interface IProjectRepo {
    public Project getProjectById(Long id);

    public List<Project> getAllProjects();
    public String saveProject(Project project);
    public String updateProject(Project project);
    public  String patchUpdateProject(Project project);
    public String deleteProject(Long id);


}
