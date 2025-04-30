package com.example.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Rol;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository ;
    private final  RolRepository rolRepository;

    public PersonServiceImpl(PersonRepository personRepository,RolRepository rolRepository){
        this.personRepository=personRepository;
        this.rolRepository=rolRepository;
    }

    @Override
    public List<Person> findAllUsersByFilter(String filter,String value){
        if(filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
        }
        else if(filter.toLowerCase().equals("lenguage") && !value.isEmpty()){
            return personRepository.findByLanguage(value);
        }
        return personRepository.findAll();
        
    }

    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        
        return rolRepository.findAll();
    }
}

