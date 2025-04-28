package com.example.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;

@Service
public class PersonServicePiml implements PersonService{
    @Override
    public List<Person> findAllByFilter(String filter,String value){
        return List.of(new Person(1l,"Luis miguel","Bermon","Otro"));
    }

}
