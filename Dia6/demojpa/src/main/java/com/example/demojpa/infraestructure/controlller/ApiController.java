package com.example.demojpa.infraestructure.controlller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.application.service.ProjectService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Project;
import com.example.demojpa.domain.Rol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService ;
    private final ProjectService projectService ;
    public ApiController(PersonService personService,ProjectService projectService ) {
        this.personService= personService;
        this.projectService= projectService;
    }

    @GetMapping("/user")
    public List<Person>findAll(
        @RequestParam(name="filter",defaultValue ="") String filter,
        @RequestParam(name="value",defaultValue ="") String value
        
    ){
        List<Person> results=personService.findAllUsersByFilter(filter,value);
    
        return results;
    }
   
    
    @PostMapping("/roles")
    public Map<String, Object> newrol( @RequestBody Rol role){
        return Map.of("ID", role.getId(), "NAME", role.getName());
    }
    @GetMapping("roles")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public List<Rol>findAllRoles(
        @RequestParam(name="filter",defaultValue ="") String filter,
        @RequestParam(name="value",defaultValue ="") String value
        
    ){
        List<Rol> results=personService.findAllRolesByFilter(filter,value);
    
        return results;
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


    
/* 

    @GetMapping("/users")
    public List<Person>findAll(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String lastname,
        @RequestParam(required = false) String language
        
    ){
        List<Person> results=personRepository.findAll();
        List<Person> listadoFiltrado = results.stream()
            .filter(Person -> name==null || Person.getName().equalsIgnoreCase(name))
            .filter(Person -> lastname==null || Person.getLastname().equalsIgnoreCase(lastname))
            .filter(Person -> language == null || Person.getLanguage().equalsIgnoreCase(language))
            .collect(Collectors.toList());
        return listadoFiltrado;
    }
*/