package com.example.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository ;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @Override
    public List<Person> findAllByFilter(String filter,String value){
        if(filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
        }
        else if(filter.toLowerCase().equals("lenguage") && !value.isEmpty()){
            return personRepository.findByLanguage(value);
        }
        return personRepository.findAll();
        
    }
}

