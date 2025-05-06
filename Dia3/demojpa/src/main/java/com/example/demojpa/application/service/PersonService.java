package com.example.demojpa.application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demojpa.domain.dto.PersonRequest;
import com.example.demojpa.domain.dto.PersonResponse;

@Service
public interface PersonService {
  

    public List<PersonResponse> findAllUsersByFilter(String filter,String value);
    public PersonResponse patchPerson(long id ,PersonRequest personDto);
    boolean updateLenguageName(String personId, String NewLenguage);
    boolean deletePerson(Long id) ;
    public PersonResponse createNewUser(PersonRequest PersonDta);

   
}
