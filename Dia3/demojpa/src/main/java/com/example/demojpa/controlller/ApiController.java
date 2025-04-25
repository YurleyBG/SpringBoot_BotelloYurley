package com.example.demojpa.controlller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demojpa.repository.PersonRepository;
import com.example.demojpa.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonRepository personRepository;

    
    public ApiController(PersonRepository personRepository) {
        this.personRepository= personRepository;
    }


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
}
