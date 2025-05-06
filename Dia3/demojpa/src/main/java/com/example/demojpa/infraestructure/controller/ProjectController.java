package com.example.demojpa.infraestructure.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.application.service.ProjectService;
import com.example.demojpa.domain.Project;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectService projectService ;
    
    public ProjectController(ProjectService projectService ) {
        this.projectService= projectService;
    }

    @GetMapping("/projects")
    public List<Project>findAllprojects23(
        @RequestParam(name="filter",defaultValue ="") String filter,
        @RequestParam(name="value",defaultValue ="") String value
        
    ){
        List<Project> results=projectService.findAllProject();
    
        return results;
    }


}
