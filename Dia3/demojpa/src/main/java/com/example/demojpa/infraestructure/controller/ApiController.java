package com.example.demojpa.infraestructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.application.service.ProjectService;
import com.example.demojpa.application.service.RolService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Project;
import com.example.demojpa.domain.Rol;
import com.example.demojpa.domain.RoleRequest;
import com.example.demojpa.domain.namePersonUpdate;
import com.example.demojpa.domain.dto.PersonRequest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final RolService rolservice;
    private final PersonService personService ;
    private final ProjectService projectService ;

    public ApiController(PersonService personService,ProjectService projectService, RolService rolservice) {
        this.personService= personService;
        this.projectService= projectService;
        this.rolservice= rolservice;
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
    public Rol newRole( @Valid @RequestBody RoleRequest role) {
        return rolservice.createNewRol(role.getName());
    }

    
    @GetMapping("/roles")  
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Rol>>findAllRoles(
        @RequestParam(name="filter",defaultValue ="") String filter,
        @RequestParam(name="value",defaultValue ="") String value
        
    ){
        List<Rol> results=rolservice.findAllRolesByFilter(filter,value);
    
        return ResponseEntity.ok(results);
    }
    @GetMapping("/projects")
    public List<Project>findAllprojects23(
        @RequestParam(name="filter",defaultValue ="") String filter,
        @RequestParam(name="value",defaultValue ="") String value
        
    ){
        List<Project> results=projectService.findAllProject();
    
        return results;
    }
    @DeleteMapping("roles/{id}")
    public ResponseEntity<Rol> removeRol(@PathVariable(name="id") Long id){
        return ResponseEntity.ok().body(rolservice.RemoveRol(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = personService.deletePerson(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putLenguageName(@PathVariable String id, @RequestBody namePersonUpdate NewLenguge) {
        
        boolean updated = personService.updateLenguageName(id, NewLenguge.getNewName());

        if (updated) {
            return ResponseEntity.ok("Lenguaje actualizado con exito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/users/{id}")
    public  ResponseEntity<Person> ParcialupdatePerson( @PathVariable Long id,@RequestBody PersonRequest PerosonDto){
        return ResponseEntity.notFound().build();
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