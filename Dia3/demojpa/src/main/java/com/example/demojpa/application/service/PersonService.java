package com.example.demojpa.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.domain.Person;

@Service
public interface PersonService {

    public List<Person> findAllByFilter(String filter,String value);
}
