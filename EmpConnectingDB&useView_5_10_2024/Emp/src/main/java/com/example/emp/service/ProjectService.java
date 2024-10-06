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
        projectDTO.setStartDate(projectEntity.getStartDate());
        projectDTO.setEndDate(projectEntity.getEndDate());
        return projectDTO;
    }

    private ProjectEntity castProjecteDtoToEntity(ProjectDTO projectDto){
        ProjectEntity project=new ProjectEntity();
        project.setId(projectDto.getId());
        project.setName(projectDto.getName());
       project.setSalary(projectDto.getSalary());
       project.setStartDate(projectDto.getStartDate());
       project.setEndDate(projectDto.getEndDate());

        return project;
    }


    @Override
    public ProjectDTO getProjectById(Long id){
        return casteProjectToDto(iProjectRepo.findById(id).get());
    }

    @Override
    public ProjectDTO findByName(String name) {
        return casteProjectToDto(iProjectRepo.findByFname(name));
    }

    @Override
    public List<ProjectDTO> getBySalary(Double salary) {
        return iProjectRepo.findBysalary(salary).stream().map(this::casteProjectToDto).collect(Collectors.toList());

    }


    @Override
    public List<ProjectDTO> getAllProjects() {
        List<ProjectEntity> projectEntityList=iProjectRepo.findAll();


        return projectEntityList.stream().map(pEn->casteProjectToDto(pEn)).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        return casteProjectToDto(iProjectRepo.save(castProjecteDtoToEntity(projectDTO)));
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO project) {
        return casteProjectToDto(iProjectRepo.save(castProjecteDtoToEntity(project)));
    }
    @Override
    public ProjectDTO patchUpdateProject(ProjectDTO project) {
        return casteProjectToDto(iProjectRepo.save(castProjecteDtoToEntity(project)));
    }

    @Override
    public String deleteProject(Long id) {
        iProjectRepo.deleteById(id);
        return "Emp deleted";
    }
}
