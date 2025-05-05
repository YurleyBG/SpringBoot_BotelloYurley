package com.example.demojpa.application.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.dto.PersonRequest;

@Service
public interface PersonService {
  

    public List<Person> findAllUsersByFilter(String filter,String value);
    public Person patchPerson(long id ,PersonRequest personDto);
    boolean updateLenguageName(String personId, String NewLenguage);
    boolean deletePerson(Long id) ;

   
}
