package com.example.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.ProjectService;
import com.example.demojpa.domain.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository _projectRepository){
        projectRepository=_projectRepository;
    }
    @Override
    public List<Project>findAllProject(){
        return projectRepository.findAll();
    }

}
