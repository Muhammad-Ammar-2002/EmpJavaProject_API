package com.example.emp.service;

import com.example.emp.repo.ProjectRepo;
import com.example.emp.repo.Project;
import com.example.emp.repo.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    private  final ProjectRepo iProjectRepo;

    public ProjectService(ProjectRepo ProjectRepo) {
        this.iProjectRepo = ProjectRepo;
    }

    @Override
    public Project getProjectById(long id){
        return iProjectRepo.getProjectById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return iProjectRepo.getAllProjects();
    }

    @Override
    public String saveProject(Project project) {
        return iProjectRepo.saveProject(project);
    }

    @Override
    public String updateProject(Project project) {
        return iProjectRepo.updateProject(project);
    }
    @Override
    public String patchUpdateProject(Project project) {
        return iProjectRepo.patchUpdateProject(project);
    }

    @Override
    public String deleteProject(Long id) {
        return iProjectRepo.deleteProject(id);
    }
}
