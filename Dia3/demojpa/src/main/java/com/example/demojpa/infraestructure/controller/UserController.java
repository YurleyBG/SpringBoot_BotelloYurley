package com.example.demojpa.infraestructure.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.namePersonUpdate;
import com.example.demojpa.domain.dto.PersonRequest;
import com.example.demojpa.domain.dto.PersonResponse;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final PersonService personService;
    
    public UserController(PersonService personService) {
        this.personService= personService;
    }

    @GetMapping("/user")
    public List<PersonResponse>findAll(
        @RequestParam(name="filter",defaultValue ="") String filter,
        @RequestParam(name="value",defaultValue ="") String value
        
    ){
        List<PersonResponse> results=personService.findAllUsersByFilter(filter,value);
    
        return results;
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

    @PostMapping("/users")
    public ResponseEntity<PersonResponse> createNewUser(@RequestBody PersonRequest PersonDta) {
        return new ResponseEntity<PersonResponse>(
            personService.createNewUser(PersonDta),
            HttpStatusCode.valueOf(200)
        );
    }
    

    @PatchMapping("/users/{id}")
    public  ResponseEntity<PersonResponse> ParcialupdatePerson( @PathVariable Long id,@RequestBody PersonRequest personDto){
        return ResponseEntity.ok().body(personService.patchPerson(id, personDto));
    }
}


