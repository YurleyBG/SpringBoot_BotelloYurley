package com.example.demojpa.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Rol;
import com.example.demojpa.domain.Passport;
import com.example.demojpa.domain.dto.PersonRequest;
import com.example.demojpa.domain.dto.PersonResponse;
import com.example.demojpa.infraestructure.error.RoldDuplicationException;

import jakarta.persistence.EntityNotFoundException; 
@Service
public class PersonServiceImpl implements PersonService{

    private final DocumentRepository documentRepository;
    private final RolRepository roleRepoitory;
    private final PersonRepository personRepository ;
    public PersonServiceImpl(PersonRepository personRepository,RolRepository roleRepoitory,DocumentRepository documentRepository){
        this.personRepository=personRepository;
        this.roleRepoitory=roleRepoitory;
        this.documentRepository=documentRepository;
    }

    @Override
    public List<PersonResponse> findAllUsersByFilter(String filter,String value){
        if(filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value).stream().map((person) ->{
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastname());
                response.setSkill(person.getLanguage());
                response.setPassport(person.getPassport()!=null);
                return response;
            }).toList();
        }
        else if(filter.toLowerCase().equals("lenguage") && !value.isEmpty()){
            return personRepository.findByLanguage(value).stream().map((person) ->{
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastname());
                response.setSkill(person.getLanguage());
                response.setPassport(person.getPassport()!=null);
                return response;
            }).toList();
        }
        return personRepository.findAll().stream().map((person) ->{
            PersonResponse response = new PersonResponse();
            response.setName(person.getName());
            response.setSurname(person.getLastname());
            response.setSkill(person.getLanguage());
            response.setPassport(person.getPassport()!=null);
            return response;
        }).toList();
        
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
    public PersonResponse patchPerson(long id, PersonRequest personDto) {
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
        PersonResponse response = new PersonResponse();
        response.setName(person.getName());
        response.setSurname(person.getLastname());
        response.setSkill(person.getLanguage());
        response.setPassport(person.getPassport()!=null);
        return response;
 
    }

    @Override
    public PersonResponse createNewUser(PersonRequest PersonDta) {
        // validamos que el usuario no este registrado 
        Optional<Person> person = personRepository.findByPassportNumber(PersonDta.getPassport());
        if (person.isPresent()){
            throw new RoldDuplicationException("el usuario ya se encuentra registrado", HttpStatus.CONFLICT);
        }
        // Buscamos el rol para el usuario
        Rol userRol= roleRepoitory.findById(1L)
            .orElseThrow(()-> new EntityNotFoundException(
                "No se encontro el rol por defecto"));
       
        // creamos el usuario temporal 
        Person newPerson = new Person();
        newPerson.setName(PersonDta.getName());
        newPerson.setLastname(PersonDta.getSurname());
        newPerson.setLanguage(PersonDta.getSkill());
        newPerson.setRole(userRol);

        // creamos el pasaporte temporal 
        Passport passport = new Passport();
        passport.setPerson(newPerson);
        passport.setNumber(PersonDta.getPassport());

        //Guardamos nuestro nuevo registro
        Person save = personRepository.save(newPerson);

        // Guardar el passport o el document
        documentRepository.save(passport);

       
        // Mapeo de person a personresponse

        save.setPassport(passport);
        
        PersonResponse response = new PersonResponse();
        response.setName(save.getName());
        response.setSurname(save.getLastname());
        response.setSkill(save.getLanguage());
        response.setPassport(save.getPassport()!=null);
        return response;
     }
}