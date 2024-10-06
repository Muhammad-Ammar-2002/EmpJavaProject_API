package com.example.emp.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepo implements IProjectRepo {



    @Override
    public Project getProjectById(Long id) {

        return new Project(1,"EmpProject","99999999","23/4/2002","2/10/2024");
    }

    @Override
    public List<Project> getAllProjects() {
        return List.of(new Project(1,"EmpProject","99999999","23/4/2002","2/10/2024"),
                new Project(1,"EmpProject","99999999","23/4/2002","2/10/2024"),
                new Project(1,"EmpProject","99999999","23/4/2002","2/10/2024"));
    }

    @Override
    public String saveProject(Project project) {
        return "Done 1 row saved;"+project.toString() ;    }

    @Override
    public String updateProject(Project project) {
        if(project !=null)
        {
            if(project.getId()==0){return "Please update your id. "+project;}
            if(project.getName()==null){return "Please update your name. "+project;}
            if(project.getSalary()==null){return "Please update your salary. "+project;}



            return  "Done 1 row updated;"+project;
        }
        return  "error";    }

    @Override
    public String patchUpdateProject(Project project) {
        return "Done 1 row updated;"+project.toString() ;     }

    @Override
    public String deleteProject(Long id) {
        return "Done 1 row deleted;";
    }
}
