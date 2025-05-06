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

import com.example.demojpa.application.service.RolService;
import com.example.demojpa.domain.Rol;
import com.example.demojpa.domain.RoleRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RolController {

    private final RolService rolservice;

    public RolController(RolService rolservice) {
        this.rolservice= rolservice;
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
   
    @DeleteMapping("roles/{id}")
    public ResponseEntity<Rol> removeRol(@PathVariable(name="id") Long id){
        return ResponseEntity.ok().body(rolservice.RemoveRol(id));
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