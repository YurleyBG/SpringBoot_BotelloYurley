package com.example.demojpa.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Rol;
import com.example.demojpa.infraestructure.error.RoldDuplicationException;

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

    @Override
    public Rol createNewRol(String name) {
        Rol newRol = new Rol();
        newRol.setName(name);
        if(GetRoleByName(name).isPresent()){
            throw new RoldDuplicationException("El Rol: "+ name +" ya esta registrado.",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return rolRepository.save(newRol);
       
    }
    private Optional<Rol> GetRoleByName(String rolName){
        return rolRepository.findByName(rolName);
    }
}

