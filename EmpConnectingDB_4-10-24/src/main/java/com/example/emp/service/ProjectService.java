package com.example.emp.service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.model.EmployeeDTO;
import com.example.emp.model.ProjectDTO;
import com.example.emp.repo.IProjectRepo;
import com.example.emp.Entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    private  final IProjectRepo iProjectRepo;

    @Autowired
    public ProjectService(IProjectRepo iProjectRepo) {
        this.iProjectRepo = iProjectRepo;
    }

    private ProjectDTO casteProjectToDto(ProjectEntity projectEntity){
        ProjectDTO projectDTO=new ProjectDTO();
        projectDTO.setId(projectEntity.getId());
        projectDTO.setName(projectEntity.getName());
        projectDTO.setSalary(projectEntity.getSalary());

        return projectDTO;
    }
    private ProjectEntity casteDtoToProject(ProjectDTO projectDTO){
        ProjectEntity projectEntity=new ProjectEntity();
        projectEntity.setId(projectDTO.getId());
        projectEntity.setName(projectDTO.getName());
        projectEntity.setSalary(projectDTO.getSalary());

        return projectEntity;
    }

    @Override
    public ProjectDTO getProjectById(Long id){
        return casteProjectToDto(iProjectRepo.getProjectById(id));
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<ProjectEntity> projectEntityList=iProjectRepo.getAllProjects();


        return projectEntityList.stream().map(pEn->casteProjectToDto(pEn)).collect(Collectors.toList());
    }

    @Override
    public String saveProject(ProjectDTO projectDTO) {
        return "Done 1 row saved;"+casteProjectToDto(iProjectRepo.saveProject(casteDtoToProject(projectDTO))).toString();
    }

    @Override
    public String updateProject(ProjectDTO projectDTO) {
        return "Done 1 row updated;"+casteProjectToDto(iProjectRepo.updateProject(casteDtoToProject(projectDTO))).toString();
    }
    @Override
    public String patchUpdateProject(ProjectDTO projectDTO) {
        return "Done 1 row updated;"+casteProjectToDto(iProjectRepo.patchUpdateProject(casteDtoToProject(projectDTO))).toString();
    }

    @Override
    public String deleteProject(Long id) {
        return iProjectRepo.deleteProject(id);
    }
}
