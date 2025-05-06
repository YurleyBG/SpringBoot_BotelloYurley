package com.example.demojpa.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.dto.PersonRequest;

import jakarta.persistence.EntityNotFoundException;
@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository ;
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
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
    public boolean deletePerson(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            personRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateLenguageName(String id, String newLenguagename) {
       
        Optional<Person> personOpti = personRepository.findById(Long.parseLong(id));
        if (personOpti.isPresent()) {
            Person person = personOpti.get();
            person.setLanguage(newLenguagename);
            personRepository.save(person);
            return true;
        }
        return false; 
        
    }

    @Override
    public Person patchPerson(long id, PersonRequest personDto) {
        Person person = personRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontro el usuario solicitado"));

        if(personDto.getName() != null) {
            person.setName(personDto.getName());
        }

        if(personDto.getSurname() != null) {
            person.setLastname(personDto.getSurname());
        }

        if(personDto.getSkill() != null) {
            person.setLanguage(personDto.getSkill());
        }

        personRepository.save(person);
        
        return person;
    }
}