package com.example.emp.repo;

import com.example.emp.Entity.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepo implements IProjectRepo {



    @Override
    public ProjectEntity getProjectById(Long id) {

        return new ProjectEntity(1,"EmpProject","99999999","23/4/2002","2/10/2024");
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        return List.of(new ProjectEntity(1,"EmpProject","99999999","23/4/2002","2/10/2024"),
                new ProjectEntity(2,"EmpProject","99999999","23/4/2002","2/10/2024"),
                new ProjectEntity(3,"EmpProject","99999999","23/4/2002","2/10/2024"));
    }

    @Override
    public ProjectEntity saveProject(ProjectEntity project) {
        return project ;    }

    @Override
    public ProjectEntity updateProject(ProjectEntity project) {
        if(project !=null)
        {
            if(project.getId()==0){return project;}
            if(project.getName()==null){return project;}
            if(project.getSalary()==null){return project;}



            return  project;
        }
        return  null;    }

    @Override
    public ProjectEntity patchUpdateProject(ProjectEntity project) {
        return project ;     }

    @Override
    public String deleteProject(Long id) {
        return "Done 1 row deleted;";
    }
}
